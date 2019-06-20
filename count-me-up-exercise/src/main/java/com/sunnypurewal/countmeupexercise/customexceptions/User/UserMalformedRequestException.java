package com.sunnypurewal.countmeupexercise.customexceptions.User;

public class UserMalformedRequestException extends RuntimeException {

    public UserMalformedRequestException() {
    }

    public UserMalformedRequestException(String message) {
        super(message);
    }

    public UserMalformedRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserMalformedRequestException(Throwable cause) {
        super(cause);
    }

    public UserMalformedRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
