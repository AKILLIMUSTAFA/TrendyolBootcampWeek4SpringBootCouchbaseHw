package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "ID does not exist")
public class IdNotFoundException extends RuntimeException {
}
