package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models;

import java.util.*;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddPlaylistRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddTrackRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.UpdatePlaylistRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.response.PlaylistResponse;
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

    public Playlist() {}

    public Playlist(String name, String description, String userId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.followersCount = new Random().nextInt(1000);
        this.tracks = new ArrayList<>();
        this.trackCount = 0;
        this.userId = userId;
    }

    public Playlist(String description, int followersCount, String id, String name, int trackCount, List<Track> tracks, String userId) {
        this.description = description;
        this.followersCount = followersCount;
        this.id = id;
        this.name = name;
        this.trackCount = trackCount;
        this.tracks = tracks;
        this.userId = userId;
    }

    public Playlist(AddPlaylistRequest addPlaylistRequest) {
        this(addPlaylistRequest.getName(), addPlaylistRequest.getDescription(), addPlaylistRequest.getUserId());
    }

    public Playlist(PlaylistResponse playlistResponse) {
        this(playlistResponse.getDescription(),playlistResponse.getFollowersCount(),playlistResponse.getId(),
                playlistResponse.getName(), playlistResponse.getTrackCount(), playlistResponse.getTracks(),
                playlistResponse.getUserId());
    }

    public PlaylistResponse createPlaylistResponse() {
        return new PlaylistResponse(
                this.id,
                this.name,
                this.description,
                this.followersCount,
                this.tracks,
                this.trackCount,
                this.userId);
    }

    public void updateByRequest(UpdatePlaylistRequest updatePlaylistRequest) {
        if(updatePlaylistRequest.getName() != null){
            this.name = updatePlaylistRequest.getName();
        }

        if(updatePlaylistRequest.getDescription() != null){
            this.description = updatePlaylistRequest.getDescription();
        }
    }

    public void addTrack(AddTrackRequest addTrackRequest){
        tracks.add(new Track(addTrackRequest));
        trackCount++;
    }

    public boolean deleteTracks(String trackName) {
        Iterator<Track> it = this.tracks.iterator();
        while (it.hasNext()) {
            Track track = it.next();
            if (track.getName().equals(trackName)) {
                it.remove();
                trackCount--;
                return true;
            }
        }
        return false;
    }
}
