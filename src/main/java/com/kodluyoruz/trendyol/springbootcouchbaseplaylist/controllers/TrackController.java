package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.controllers;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddTrackRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.response.TrackResponse;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions.IdNotFoundException;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions.InvalidIdException;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions.RequestMissingInformationException;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Track;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.services.TrackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({ "/v1/playlists/{playlistId}/tracks" })
public class TrackController {

    TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @DeleteMapping
    public ResponseEntity deleteATrack(@PathVariable String playlistId, @RequestParam String trackName) {
        // will be implemented
        if (playlistId.contains("*")) {
            throw new InvalidIdException();
        }

        if(!this.trackService.deleteByTrack(playlistId,trackName))
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

        Track track = this.trackService.createATrack(playlistId,addTrackRequest);

        URI location = URI.create(String.format("/playlists/%s/tracks/%s", playlistId, track.getName()));
        return ResponseEntity.created(location).build();
    }
}
