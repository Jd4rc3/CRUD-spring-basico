package com.example.crud.controller.util;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Data
public class CustomResponse {
    private Boolean error;

    private Integer status;

    private String message;

    private Object data;

    public CustomResponse() {
        error = false;
        message = "";
        data = null;
    }

    public CustomResponse fillFields(Boolean error, String message, Object data, HttpStatus status) {
        this.error = error;
        this.message = message;
        this.data = data;
        this.status = status.value();
        return this;
    }
}

