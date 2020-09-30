package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.services;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddPlaylistRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.UpdatePlaylistRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Playlist;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.repositories.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Playlist findByPlaylistId(String playlistId) {
        return this.playlistRepository.findByPlaylistId(playlistId);
    }

    public boolean deleteById(String playlistsId) {
        return this.playlistRepository.deleteById(playlistsId);
    }

    public boolean isAddPlaylistRequestValid(AddPlaylistRequest request) {
        return this.playlistRepository.isAddPlaylistRequestValid(request);
    }

    public Playlist createAPlaylist(AddPlaylistRequest addPlaylistRequest) {
        return this.playlistRepository.insert(addPlaylistRequest);
    }

    public boolean updateAPlaylist(String playlistId, UpdatePlaylistRequest updatePlaylistRequest) {
        Playlist playlist = playlistRepository.findByPlaylistId(playlistId);
        playlist.updateByRequest(updatePlaylistRequest);
        return playlistRepository.update(playlist);
    }

    public List<Playlist> findAll(String userId) {
        return this.playlistRepository.findAll(userId);
    }
}
