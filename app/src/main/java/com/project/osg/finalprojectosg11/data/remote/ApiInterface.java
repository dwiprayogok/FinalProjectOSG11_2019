package com.project.osg.finalprojectosg11.data.remote;

import com.project.osg.finalprojectosg11.model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @GET("/api/people/")
    Call<Movie> getAllPeople();
}
