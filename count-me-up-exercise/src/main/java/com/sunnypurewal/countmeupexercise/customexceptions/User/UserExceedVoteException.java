package com.sunnypurewal.countmeupexercise.customexceptions.User;

public class UserExceedVoteException extends RuntimeException {

    public UserExceedVoteException() {
    }

    public UserExceedVoteException(String message) {
        super(message);
    }

    public UserExceedVoteException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExceedVoteException(Throwable cause) {
        super(cause);
    }

    public UserExceedVoteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
