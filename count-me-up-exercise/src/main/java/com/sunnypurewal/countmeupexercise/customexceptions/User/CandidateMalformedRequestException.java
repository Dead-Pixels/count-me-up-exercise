package com.sunnypurewal.countmeupexercise.customexceptions.User;

public class CandidateMalformedRequestException extends RuntimeException {

    public CandidateMalformedRequestException() {
    }

    public CandidateMalformedRequestException(String message) {
        super(message);
    }

    public CandidateMalformedRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public CandidateMalformedRequestException(Throwable cause) {
        super(cause);
    }

    public CandidateMalformedRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
