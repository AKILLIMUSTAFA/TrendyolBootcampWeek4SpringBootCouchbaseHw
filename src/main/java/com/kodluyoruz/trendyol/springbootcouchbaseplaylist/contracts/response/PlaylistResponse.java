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
}
