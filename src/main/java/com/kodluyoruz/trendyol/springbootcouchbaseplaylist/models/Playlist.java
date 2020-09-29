package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Random;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Playlist {

    private String id;
    private String name;
    private String description;
    private int followersCount;
    private List<Track> tracks;
    private int trackCount;
    private String userId;

    public Playlist(String name, String description, String userId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.followersCount = new Random().nextInt(1000);
        this.tracks = new ArrayList<>();
        this.trackCount = 0;
        this.userId = userId;
    }

    public Playlist(String id, String name, String description, int followersCount, List<Track> tracks, int trackCount, String userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.followersCount = followersCount;
        this.tracks = tracks;
        this.trackCount = trackCount;
        this.userId = userId;
    }


}
