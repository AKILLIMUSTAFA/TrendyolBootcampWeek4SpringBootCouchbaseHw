package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.repositories;

import com.couchbase.client.core.error.DocumentNotFoundException;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.kv.MutationResult;
import com.couchbase.client.java.query.QueryResult;


import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request.AddPlaylistRequest;
import com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models.Playlist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistRepository {

    private final Cluster couchbaseCluster;
    private final Collection playlistCollection;

    public PlaylistRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = playlistCollection;
    }

    public Playlist findByPlaylistId(String playlistId) {
        try{
            GetResult getResult = playlistCollection.get(playlistId);
            Playlist playlist = getResult.contentAs(Playlist.class);
            return playlist;
        }catch (DocumentNotFoundException ex){
            return null;
        }
    }

    public boolean deleteById(String playlistsId) {
        try{
            playlistCollection.remove(playlistsId);
            return true;
        }catch (DocumentNotFoundException ex){
            return false;
        }
    }

    public boolean isAddPlaylistRequestValid(AddPlaylistRequest request) {

        if(request.getName() == null || request.getDescription() == null || request.getUserId() == null){
            return false;
        }

        return true;
    }

    public Playlist insert(AddPlaylistRequest addPlaylistRequest) {
        Playlist newPlaylist = new Playlist(addPlaylistRequest);
        playlistCollection.insert(newPlaylist.getId(), newPlaylist);
        return newPlaylist;
    }

    public boolean update(Playlist playlist) {
        try{
            playlistCollection.replace(playlist.getId(), playlist);;
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public List<Playlist> findAll(String userId) {
        String statement;
        if(userId == null || userId.equals("")){
            statement = "Select id, name, description, followersCount, tracks, trackCount, userId from playlist";
        } else{
            statement = "Select id, name, description, followersCount, tracks, trackCount, userId from playlist where userId = '" + userId + "'";
        }
        QueryResult query = couchbaseCluster.query(statement);
        return query.rowsAs(Playlist.class);
    }
}
