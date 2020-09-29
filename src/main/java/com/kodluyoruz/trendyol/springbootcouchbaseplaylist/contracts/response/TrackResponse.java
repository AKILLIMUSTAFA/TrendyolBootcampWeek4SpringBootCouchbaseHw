package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrackResponse {
    private String name;
    private String length;
    private String artist;
}
