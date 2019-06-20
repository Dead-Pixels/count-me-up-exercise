package com.sunnypurewal.countmeupexercise.customexceptions.User;

import com.sunnypurewal.countmeupexercise.customexceptions.BaseErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserRestExceptionHandler {

    //intially I was going to just create an exception and handle it back but I thought it would make more sense to
    //actually create some custom exceptions which would make more sense to somebody reading the code and give
    //useful and relevant error information

    @ExceptionHandler
    public ResponseEntity<BaseErrorResponse> handleUserExceededVoteException(UserExceedVoteException e) {
        BaseErrorResponse error = new BaseErrorResponse(HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<BaseErrorResponse> handleUserMalformedRequestException(UserMalformedRequestException e) {
        BaseErrorResponse error = new BaseErrorResponse(HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //Catch all exception to cover all other bases
    @ExceptionHandler
    public ResponseEntity<BaseErrorResponse> handleException(Exception e) {
        BaseErrorResponse error = new BaseErrorResponse(HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
