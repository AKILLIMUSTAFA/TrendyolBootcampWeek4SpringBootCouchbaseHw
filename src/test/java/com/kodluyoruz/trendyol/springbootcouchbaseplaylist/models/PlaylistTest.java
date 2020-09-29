package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlaylistTest {

    Playlist sut;


    @BeforeEach
    public void setup() {
        sut = new Playlist("Best playlist","This is my list","36bcb5e141ddf4e23d" );
    }

    @AfterEach
    public void cleanup() {
        sut = null;
    }

    @Test
    public void shouldCreatePlaylist(){
        //Arrange


        //Act


        //Assert


    }


}
