package com.yobel.proyecto_rickymorty.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Episode {
     private int id;
     private String name;
     private String air_date;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;
}
