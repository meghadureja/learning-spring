package edu.practice.spring.exception;

import edu.practice.spring.constants.ApplicationConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * centralize the exception handling logic to one class which is capable to handle exceptions thrown
 * from any handler class/ controller class – then we can use @ControllerAdvice annotation.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
        List<ValidationError> errors= new ArrayList<>();
        ValidationError error = new ValidationError();
        error.setMessage(ex.getLocalizedMessage());
        errors.add(error);
        ErrorResponse errorResponse = new ErrorResponse(ApplicationConstants.SERVER_ERROR, errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
