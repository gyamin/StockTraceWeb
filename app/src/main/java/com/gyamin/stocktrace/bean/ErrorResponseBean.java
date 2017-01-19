package com.gyamin.stocktrace.bean;

import java.util.List;
import java.util.Map;

public class ErrorResponseBean {
    private Integer status;
    private String message;
    private List<Map<String, Object>> fieldErrors;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Map<String, Object>> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<Map<String, Object>> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
