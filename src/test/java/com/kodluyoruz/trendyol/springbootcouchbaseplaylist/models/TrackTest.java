package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrackTest {

    Track sut;


    @BeforeEach
    public void setup() {
        sut = new Track("First-Track","John","100");
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
