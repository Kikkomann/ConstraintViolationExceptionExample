package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Fejlsvar
 */
public class ErrorMessage {
  @JsonProperty("errors")
  @Valid
  private List<Error> errors = new ArrayList<>();

  public ErrorMessage errors(List<Error> errors) {
    this.errors = errors;
    return this;
  }

  public ErrorMessage addErrorsItem(Error errorsItem) {
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Get errors
   * @return errors
  */
  @NotNull

  @Valid

  public List<Error> getErrors() {
    return errors;
  }
}

