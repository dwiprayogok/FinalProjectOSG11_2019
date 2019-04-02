package com.project.osg.finalprojectosg11.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("results")
    List<MovieDetail> films;

    public Movie(List<MovieDetail> films) {
        this.films = films;
    }

    public List<MovieDetail> getFilms() {
        return films;
    }
}
