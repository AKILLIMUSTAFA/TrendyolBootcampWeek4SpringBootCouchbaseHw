package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Track {

    private String name;
    private String length;
    private String artist;

    public Track(String name, String length, String artist) {
        this.name = name;
        this.length = length;
        this.artist = artist;
    }


}
