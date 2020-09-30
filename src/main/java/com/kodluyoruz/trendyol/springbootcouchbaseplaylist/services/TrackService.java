package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.services;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddTrackRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Playlist;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Track;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.repositories.PlaylistRepository;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.repositories.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {

    private final TrackRepository trackRepository;
    private final PlaylistRepository playlistRepository;

    public TrackService(TrackRepository trackRepository, PlaylistRepository playlistRepository) {
        this.trackRepository = trackRepository;
        this.playlistRepository = playlistRepository;
    }

    public boolean deleteByTrack(String playlistId, String trackName) {
        try{
            Playlist playlist = playlistRepository.findByPlaylistId(playlistId);
            boolean result = playlist.deleteTracks(trackName);
            if(result){
                playlistRepository.update(playlist);
            }
            return true;
        }catch (NullPointerException ex){
            return false;
        }
    }

    public boolean isAddTrackRequestValid(AddTrackRequest addTrackRequest) {
        return this.trackRepository.isAddTrackRequestValid(addTrackRequest);
    }

    public Track createATrack(String playlistId, AddTrackRequest addTrackRequest) {
        Playlist playlist = playlistRepository.findByPlaylistId(playlistId);
        playlist.addTrack(addTrackRequest);
        playlistRepository.update(playlist);
        return playlist.getTracks().get(playlist.getTracks().size() - 1);
    }
}
