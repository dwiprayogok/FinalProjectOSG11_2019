package com.project.osg.finalprojectosg11.data;

import com.project.osg.finalprojectosg11.model.Movie;

public interface MovieDataSource  {

    void getListMovies(GetMoviesCallback callback);


    interface GetMoviesCallback {
        void onMovieLoaded(Movie data);
        void onDataNotAvailable(String errorMessage);
    }
}
