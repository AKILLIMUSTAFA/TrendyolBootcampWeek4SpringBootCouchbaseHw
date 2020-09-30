package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.response;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Track;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlaylistResponse {
    private String id;
    private String name;
    private String description;
    private int followersCount;
    private List<Track> tracks;
    private int trackCount;
    private String userId;

    public PlaylistResponse(String id, String name, String description, int followersCount, List<Track> tracks, int trackCount, String userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.followersCount = followersCount;
        this.tracks = tracks;
        this.trackCount = trackCount;
        this.userId = userId;
    }
}
