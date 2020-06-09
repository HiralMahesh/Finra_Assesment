package com.finra.assessment.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class WrongLengthException extends RuntimeException {


    public WrongLengthException( ) {
        super("Length of Number is not correct must be 7 or 10 digit");

    }
}
