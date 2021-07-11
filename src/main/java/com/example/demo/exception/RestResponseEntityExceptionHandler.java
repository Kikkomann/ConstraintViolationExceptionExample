package com.example.demo.exception;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path.Node;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.model.Error;
import com.example.demo.model.ErrorMessage;
import com.example.demo.clslogmanager.factory.LogManager;
import com.example.demo.clslogmanager.factory.LogManagerFactory;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	LogManagerFactory logManagerFactory;

	private LogManager clsLogManager;

	@Autowired
	private Environment environment;

	@PostConstruct
	private void initLogManager() {
		clsLogManager = logManagerFactory.getLogManager();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<Object> handleConflict(ConstraintViolationException ex, HttpServletRequest request) {
		ConstraintViolation<?> violation = ex.getConstraintViolations().iterator().next();
		String invalidParameter = "";
		String invalidValue = violation.getInvalidValue().toString();
		ResponseEntity<Object> responseEntity;
		ErrorMessage errorMessage;

		for (Node node : violation.getPropertyPath()) {
			invalidParameter = node.getName();
		}

		if (invalidParameter.equalsIgnoreCase("customQueryParameter")) {
			errorMessage = setErrorMessage("422.9", HttpStatus.UNPROCESSABLE_ENTITY.value(), invalidValue);
			clsLogManager.writeInternalError(ex); // This is the log message that does not get printed
			responseEntity = writeToAuditlog(errorMessage);
			return responseEntity;
		}

		clsLogManager.writeInternalError(ex);
		errorMessage = setErrorMessage("500.1", HttpStatus.INTERNAL_SERVER_ERROR.value(), "");
		responseEntity = writeToAuditlog(errorMessage);
		return responseEntity;
	}

	private ErrorMessage setErrorMessage(String httpCode, int httpStatus, String invalidValue) {
		Error fejl = new Error();
		fejl.setKode(httpCode);
		fejl.setStatus(Integer.toString(httpStatus));
		fejl.setBesked(environment.getProperty("error.msg." + httpCode));
		fejl.setData(invalidValue);
		fejl.setType("fejl");

		return new ErrorMessage().addErrorsItem(fejl);
	}

	private ResponseEntity<Object> writeToAuditlog(ErrorMessage errorMessage) {
		clsLogManager.writeLogError(errorMessage.getErrors().get(0).getBesked(),
		HttpStatus.UNPROCESSABLE_ENTITY.value());
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
}