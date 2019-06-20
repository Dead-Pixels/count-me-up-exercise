package com.sunnypurewal.countmeupexercise.customexceptions.candidate;

import com.sunnypurewal.countmeupexercise.customexceptions.BaseErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CandidateRestExceptionHandler {

    //intially I was going to just create an exception and handle it back but I thought it would make more sense to
    //actually create some custom exceptions which would make more sense to somebody reading the code and give
    //useful and relevant error information


    //Specific error when candidate cannot be found
    @ExceptionHandler
    public ResponseEntity<BaseErrorResponse> handleCandidateNotFoundException(CandidateNotFoundException e){
        BaseErrorResponse error = new BaseErrorResponse(HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BaseErrorResponse> handleCandidateMalformedRequestException(CandidateMalformedRequestException e){
        BaseErrorResponse error = new BaseErrorResponse(HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    //Catch all exception to cover all other bases
    @ExceptionHandler
    public ResponseEntity<BaseErrorResponse> handleException(Exception e){
        BaseErrorResponse error = new BaseErrorResponse(HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
