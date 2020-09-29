package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.services;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddPlaylistRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.UpdatePlaylistRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.response.PlaylistResponse;
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

    public PlaylistResponse findByPlaylistId(String playlistId) {
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

    public boolean updateAPlaylist(String playlistsId, UpdatePlaylistRequest updatePlaylistRequest) {
        return this.playlistRepository.update(playlistsId,updatePlaylistRequest);
    }

    public List<PlaylistResponse> findAll(String name, String followersCount, String trackCount,
                                          String userId, Integer pageOffset, Integer pageSize) {
        return this.playlistRepository.findAll(name, followersCount,trackCount, userId, pageOffset, pageSize);
    }
}
