package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "You must include all the necessary information")
public class RequestMissingInformationException extends RuntimeException {
}
