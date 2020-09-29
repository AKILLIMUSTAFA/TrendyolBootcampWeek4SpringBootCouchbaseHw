package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.repositories;

import com.couchbase.client.core.error.DocumentNotFoundException;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;


import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddPlaylistRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.UpdatePlaylistRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.response.PlaylistResponse;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Playlist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistRepository {

    /*private final Cluster couchbaseCluster;
    private final Collection playlistCollection;

    public PlaylistRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = playlistCollection;
    }*/

    public PlaylistResponse findByPlaylistId(String playlistId) {
        return null;
    }

    public boolean deleteById(String playlistsId) {
        return true;
    }

    public boolean isAddPlaylistRequestValid(AddPlaylistRequest request) {
        return true;
    }

    public Playlist insert(AddPlaylistRequest addPlaylistRequest) {
        return null;
    }

    public boolean update(String playlistsId, UpdatePlaylistRequest updatePlaylistRequest) {
        return true;
    }

    public List<PlaylistResponse> findAll(String name, String followersCount, String trackCount,
                                          String userId, Integer pageOffset, Integer pageSize) {
        return null;
    }
}
