package com.krungsri.aycap.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class BaseController {
  public Logger log = LoggerFactory.getLogger(getClass());

  public String extractExceptionDetail(Exception exception) {
    StringBuilder errorMsg =  new StringBuilder();

    if (exception != null) {
      errorMsg.append(exception.toString());
    }

    if (Objects.requireNonNull(exception).getMessage() != null) {
      errorMsg.append(" - ").append(exception.getMessage());
    }

    if (exception.getCause() != null && exception.getCause().getCause() != null) {
      errorMsg.append(" - ").append(exception.getCause());
    }

    if (exception.getStackTrace().length > 0) {
      errorMsg.append(" - ").append(exception.getStackTrace()[0]);
    }

    return errorMsg.toString();
  }
}
