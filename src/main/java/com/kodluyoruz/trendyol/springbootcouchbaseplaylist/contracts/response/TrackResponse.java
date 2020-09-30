package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.response;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Track;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TrackResponse {
    private String name;
    private String length;
    private String artist;

    public TrackResponse(String name, String length, String artist) {
        this.name = name;
        this.length = length;
        this.artist = artist;
    }
}
