package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private String error_type;
    private String error_description;
}
