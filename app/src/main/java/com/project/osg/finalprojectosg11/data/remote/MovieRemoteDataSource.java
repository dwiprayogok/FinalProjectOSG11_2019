package com.project.osg.finalprojectosg11.data.remote;

import android.telecom.Call;

import com.project.osg.finalprojectosg11.data.MovieDataSource;
import com.project.osg.finalprojectosg11.model.Movie;

public class MovieRemoteDataSource implements MovieDataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListMovies(GetMoviesCallback callback) {

    }
}
