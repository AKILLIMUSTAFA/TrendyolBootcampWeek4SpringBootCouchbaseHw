package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.controllers;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddPlaylistRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.UpdatePlaylistRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.response.PlaylistResponse;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions.ExceptionHandlers;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions.IdNotFoundException;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions.InvalidIdException;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.exceptions.RequestMissingInformationException;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Playlist;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.services.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;
    private final ExceptionHandlers errorService;

    public PlaylistController(PlaylistService playlistService, ExceptionHandlers errorService) {
        this.playlistService = playlistService;
        this.errorService = errorService;
    }

    @GetMapping("/{playlistsId}")
    public ResponseEntity getAPlaylist(@PathVariable String playlistsId) {
        if (playlistsId.contains("-")) {
            throw new InvalidIdException();
        }

        PlaylistResponse response = this.playlistService.findByPlaylistId(playlistsId);

        if(response == null)
        {
            throw new IdNotFoundException();
        }

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{playlistsId}")
    public ResponseEntity deleteAPlaylist(@PathVariable String playlistsId) {
        if (playlistsId.contains("-")) {
            throw new InvalidIdException();
        }

        if(!this.playlistService.deleteById(playlistsId))
        {
            throw new IdNotFoundException();
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity createAPlaylist(@RequestBody AddPlaylistRequest addPlaylistRequest) {
        if(addPlaylistRequest == null || !this.playlistService.isAddPlaylistRequestValid(addPlaylistRequest)){
            throw new RequestMissingInformationException();
        }

        Playlist playlist = this.playlistService.createAPlaylist(addPlaylistRequest);

        URI location = URI.create(String.format("/playlists/%s", playlist.getId()));
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{playlistsId}")
    public ResponseEntity updateAPlaylist(@PathVariable String playlistsId, @RequestParam UpdatePlaylistRequest updatePlaylistRequest) {
        if(updatePlaylistRequest == null){
            throw new RequestMissingInformationException();
        }

        if (playlistsId.contains("-")) {
            throw new InvalidIdException();
        }

        if(!this.playlistService.updateAPlaylist(playlistsId,updatePlaylistRequest))
        {
            throw new IdNotFoundException();
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PlaylistResponse>> getSeveralPlaylist(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String followersCount,
            @RequestParam(required = false) String trackCount,
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) Integer pageOffset,
            @RequestParam(required = false) Integer pageSize
    ) {

        List<PlaylistResponse> playlists = this.playlistService.findAll(name, followersCount,
                trackCount, userId, pageOffset, pageSize);

        return ResponseEntity.ok(playlists);
    }

}
