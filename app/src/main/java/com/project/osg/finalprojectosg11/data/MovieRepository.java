package com.project.osg.finalprojectosg11.data;

import com.project.osg.finalprojectosg11.data.local.MovieLocalDataSource;
import com.project.osg.finalprojectosg11.data.remote.MovieRemoteDataSource;

public class MovieRepository implements MovieDataSource {

    public MovieRepository(MovieRemoteDataSource movieRemoteDataSource, MovieLocalDataSource movieLocalDataSource) {

    }

    @Override
    public void getListMovies(GetMoviesCallback callback) {

    }
}
