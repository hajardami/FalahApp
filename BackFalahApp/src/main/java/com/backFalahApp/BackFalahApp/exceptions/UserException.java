package com.backFalahApp.BackFalahApp.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

public class UserException extends GeneralException {
    public UserException(String code, String message) {
        super(code, message);
    }

    public UserException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public UserException(String code, Exception exception) {
        super(code, exception);
    }

    public UserException(Exception exception) {
        super(exception);
    }
}
