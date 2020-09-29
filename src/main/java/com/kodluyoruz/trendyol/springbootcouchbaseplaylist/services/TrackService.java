package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.services;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddTrackRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.UpdateTrackRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.response.TrackResponse;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Track;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.repositories.PlaylistRepository;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.repositories.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<TrackResponse> findAllByPlaylistId(String playlistId) {
        return this.trackRepository.findAllByPlaylistId(playlistId);
    }

    public TrackResponse findByTrackName(String playlistId, String trackName) {
        return this.trackRepository.findByTrackName(playlistId,trackName);
    }

    public boolean deleteByTrackName(String playlistId, String trackName) {
        return this.trackRepository.deleteByTrackName(playlistId,trackName);
    }

    public boolean isAddTrackRequestValid(AddTrackRequest addTrackRequest) {
        return this.trackRepository.isAddTrackRequestValid(addTrackRequest);
    }

    public Track createATrack(AddTrackRequest addTrackRequest) {
        return this.trackRepository.insert(addTrackRequest);
    }

    public boolean updateATrack(String playlistId, String trackName, UpdateTrackRequest updateTrackRequest) {
        return this.trackRepository.update(playlistId,trackName,updateTrackRequest);
    }
}
