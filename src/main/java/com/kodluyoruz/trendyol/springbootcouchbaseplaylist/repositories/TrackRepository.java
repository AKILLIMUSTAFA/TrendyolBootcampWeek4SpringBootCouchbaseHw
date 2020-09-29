package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.repositories;

import com.couchbase.client.core.error.DocumentNotFoundException;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddTrackRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.UpdateTrackRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.response.TrackResponse;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Track;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrackRepository {

    /*private final Cluster couchbaseCluster;
    private final Collection playlistCollection;

    public TrackRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = playlistCollection;
    }*/

    public List<TrackResponse> findAllByPlaylistId(String playlistId) {
        return null;
    }

    public TrackResponse findByTrackName(String playlistId, String trackName) {
        return null;
    }

    public boolean deleteByTrackName(String playlistId, String trackName) {
        return true;
    }

    public boolean isAddTrackRequestValid(AddTrackRequest addTrackRequest) {
        return true;
    }

    public Track insert(AddTrackRequest addTrackRequest) {
        return null;
    }

    public boolean update(String playlistId, String trackName, UpdateTrackRequest updateTrackRequest) {
        return true;
    }
}
