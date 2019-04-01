package com.project.osg.finalprojectosg11.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("results")
    List<MovieDetail> movies;

    public Movie(List<MovieDetail> movie) {
        this.movies = movies;
    }

    public List<MovieDetail> getMovie() {
        return movies;
    }
}
