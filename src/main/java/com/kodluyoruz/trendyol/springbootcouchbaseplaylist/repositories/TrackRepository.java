package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.repositories;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;

import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddTrackRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrackRepository {

    private final Cluster couchbaseCluster;
    private final Collection playlistCollection;

    public TrackRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = playlistCollection;
    }

    public boolean isAddTrackRequestValid(AddTrackRequest addTrackRequest) {
        if(addTrackRequest.getName() == null || addTrackRequest.getLength() == null || addTrackRequest.getArtist() == null){
            return false;
        }

        return true;
    }
}
