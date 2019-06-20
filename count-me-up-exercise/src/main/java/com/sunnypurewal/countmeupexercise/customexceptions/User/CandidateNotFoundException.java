package com.sunnypurewal.countmeupexercise.customexceptions.User;

public class CandidateNotFoundException extends RuntimeException {

    public CandidateNotFoundException() {
    }

    public CandidateNotFoundException(String message) {
        super(message);
    }

    public CandidateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CandidateNotFoundException(Throwable cause) {
        super(cause);
    }

    public CandidateNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
