package com.example.demo.clslogmanager;

import static net.logstash.logback.argument.StructuredArguments.kv;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.clslogmanager.factory.LogManager;
import com.example.demo.clslogmanager.logmodel.*;

public class ClsLogManager implements LogManager {

	private Logger logger;
	private LogEventAuditlogError logEventAuditlogError;

	public ClsLogManager() {
		this.logger = LoggerFactory.getLogger("ClsLogManager");
		this.logEventAuditlogError = new LogEventAuditlogError();
	}

	/**
	 * Prints the auditlog upon an error in the given request.
	 * 
	 * @param errorLogMessage The error message in the desired format. This should
	 *                        contain both the error log message and the provided
	 *                        query parameters.
	 * @param statusCode      The http response code for the failed request.
	 */
	public void writeLogError(String errorLogMessage, int statusCode) {

		try {
			logEventAuditlogError.setLogEventError(errorLogMessage, statusCode);
			writeAuditlogLineError();
		} catch (UnknownHostException e) {
			logger.info("Ip adress does not exist {}", e.toString());
		}
	}

	/**
	 * Writes the exception information to the loggin output.
	 * 
	 * @param exception
	 */
	public void writeInternalError(Exception exception) {
		writeLogLine("ERROR", "exception", exception);
	}


	/**
	 * Write a custom line in the log.
	 * 
	 * @param type      The name of the type to log
	 * @param logObject The data to log
	 */
	private void writeLogLine(String type, Object logObject) {
		logger.info(type, kv("LogType", type), kv("LogMessage", logObject));
	}

	/**
	 * Write a custom line in the log with a specified log level.
	 * 
	 * @param level     The log level the log should have ("INFO" is default).
	 * @param type      The name of the type to log.
	 * @param logObject The data to log.
	 */
	private void writeLogLine(String level, String type, Object logObject) {
		switch (level) {
			case "ERROR":
				logger.error(logObject.getClass().getName(), kv("LogType", type), kv("LogMessage", logObject));
				break;
			default:
				writeLogLine(type, logObject);
				break;
		}
	}

	private void writeAuditlogLineError() {
		logger.info("auditlog", kv("LogType", "auditlog"), kv("Event", logEventAuditlogError));
	}

}
