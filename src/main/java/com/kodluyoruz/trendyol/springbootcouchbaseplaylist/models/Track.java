package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddTrackRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.response.TrackResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Track {

    private String name;
    private String length;
    private String artist;

    public Track() {}

    public Track(String name, String length, String artist) {
        this.name = name;
        this.length = length;
        this.artist = artist;
    }

    public Track(AddTrackRequest addTrackRequest) {
        this(addTrackRequest.getName(), addTrackRequest.getLength(), addTrackRequest.getArtist());
    }

    public TrackResponse createTrackResponse() {
        return new TrackResponse(
                this.name,
                this.length,
                this.artist);
    }
}
