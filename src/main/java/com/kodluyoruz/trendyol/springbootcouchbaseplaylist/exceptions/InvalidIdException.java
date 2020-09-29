package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "ID format is invalid")
public class InvalidIdException extends RuntimeException {
}
