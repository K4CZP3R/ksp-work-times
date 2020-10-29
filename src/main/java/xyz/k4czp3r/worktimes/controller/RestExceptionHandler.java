package xyz.k4czp3r.worktimes.controller;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import xyz.k4czp3r.worktimes.exception.IllegalInputException;
import xyz.k4czp3r.worktimes.model.ApiErrorResponse;

import java.text.ParseException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiErrorResponse apiErrorResponse) {
        return new ResponseEntity<>(apiErrorResponse, apiErrorResponse.getStatus());
    }

    @ExceptionHandler(IllegalInputException.class)
    protected ResponseEntity<Object> handleIllegalInput(IllegalInputException ex){
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.NOT_ACCEPTABLE, ex);
        return buildResponseEntity(apiErrorResponse);
    }


}
