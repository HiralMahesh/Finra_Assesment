package com.finra.assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Custom Exception Class
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidInputException extends RuntimeException{

        public InvalidInputException( ) {
            super("Invalid Input");

        }


}
