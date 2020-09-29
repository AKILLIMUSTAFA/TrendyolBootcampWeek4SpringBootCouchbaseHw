package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ExceptionHandlers {

    private final Logger log = LoggerFactory.getLogger(ExceptionHandlers.class);

    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleIdNotFoundException(final IdNotFoundException ex) {
        log.error("ID not found thrown");
        return new ErrorResponse("ID_NOT_FOUND", "The ID was not found");
    }

    @ExceptionHandler(InvalidIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleInvalidIdException(final InvalidIdException ex) {
        log.error("Invalid ID thrown");
        return new ErrorResponse("INVALID_ID_INFORMATION", "ID format is invalid");
    }

    @ExceptionHandler(RequestMissingInformationException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ErrorResponse handleRequestMissingInformationException(final RequestMissingInformationException ex) {
        log.error("Request Missing Information thrown");
        return new ErrorResponse("MISSING_INFORMATION", "You must include all the necessary information");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ErrorResponse handleThrowable(final Throwable ex) {
        log.error("Unexpected Error", ex);
        return new ErrorResponse("INTERNAL_SERVER_ERROR", "An unexpected internal server error occurred");
    }
}
