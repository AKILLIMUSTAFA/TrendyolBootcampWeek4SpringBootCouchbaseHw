package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPlaylistRequest {
    private String name;
    private String description;
    private String userId;
}
