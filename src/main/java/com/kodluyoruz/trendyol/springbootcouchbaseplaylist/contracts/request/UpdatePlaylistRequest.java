package com.kodluyoruz.trendyol.springbootcouchbaseplaylist.contracts.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePlaylistRequest {
    private String name;
    private String description;
}
