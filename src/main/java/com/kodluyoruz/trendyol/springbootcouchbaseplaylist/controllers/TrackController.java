package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.controllers;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddTrackRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.UpdateTrackRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.response.TrackResponse;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions.IdNotFoundException;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions.InvalidIdException;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions.RequestMissingInformationException;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Playlist;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Track;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.services.TrackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping({ "/v1/playlists/{playlistId}/tracks" })
public class TrackController {

    TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public ResponseEntity getAPlaylistTracks(@PathVariable String playlistId) {
        if (playlistId.contains("-")) {
            throw new InvalidIdException();
        }

        List<TrackResponse> episodes = this.trackService.findAllByPlaylistId(playlistId);
        return ResponseEntity.ok(episodes);
    }

    @GetMapping("/{trackName}")
    public ResponseEntity getATrack(@PathVariable String playlistId, @PathVariable String trackName) {
        if (playlistId.contains("-")) {
            throw new InvalidIdException();
        }

        TrackResponse response = this.trackService.findByTrackName(playlistId,trackName);

        if(response == null)
        {
            throw new IdNotFoundException();
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{trackName}")
    public ResponseEntity deleteAEpisode(@PathVariable String playlistId, @PathVariable String trackName) {
        // will be implemented
        if (playlistId.contains("-")) {
            throw new InvalidIdException();
        }

        if(!this.trackService.deleteByTrackName(playlistId,trackName))
        {
            throw new IdNotFoundException();
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity createATrack(@PathVariable String playlistId, @RequestBody AddTrackRequest addTrackRequest) {
        if(addTrackRequest == null || !this.trackService.isAddTrackRequestValid(addTrackRequest)){
            throw new RequestMissingInformationException();
        }

        Track track = this.trackService.createATrack(addTrackRequest);

        URI location = URI.create(String.format("/playlists/%s/tracks/%s", playlistId, track.getName()));
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{episodeId}")
    public ResponseEntity updateATrack(@PathVariable String playlistId, @PathVariable String trackName, @RequestParam UpdateTrackRequest updateTrackRequest) {
        if(updateTrackRequest == null){
            throw new RequestMissingInformationException();
        }

        if (playlistId.contains("-")) {
            throw new InvalidIdException();
        }

        if(!this.trackService.updateATrack(playlistId,trackName,updateTrackRequest))
        {
            throw new IdNotFoundException();
        }

        return ResponseEntity.noContent().build();
    }
}
