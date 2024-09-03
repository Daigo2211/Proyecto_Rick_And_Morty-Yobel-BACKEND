package com.yobel.proyecto_rickymorty.Models;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Character {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;
    private String firstSeenIn;

    public String getFirstSeenIn() {
        return firstSeenIn;
    }

    public void setFirstSeenIn(String firstSeenIn) {
        this.firstSeenIn = firstSeenIn;
    }

    public static class Origin{
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Location{
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
