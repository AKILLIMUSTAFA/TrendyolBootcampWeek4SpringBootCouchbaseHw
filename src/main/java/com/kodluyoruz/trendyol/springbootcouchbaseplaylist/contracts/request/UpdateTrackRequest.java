package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTrackRequest {
    private String name;
    private String length;
    private String artist;
}
