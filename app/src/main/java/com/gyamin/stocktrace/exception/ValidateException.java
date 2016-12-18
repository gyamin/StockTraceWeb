package com.gyamin.stocktrace.exception;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ValidateException extends ApplicationException{
    public ValidateException(String message) {
        super(message);
    }
    public List<FieldError> errors;
}