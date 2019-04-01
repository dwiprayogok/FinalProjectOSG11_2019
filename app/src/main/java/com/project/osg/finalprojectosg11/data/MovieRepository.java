package com.project.osg.finalprojectosg11.data;

import com.project.osg.finalprojectosg11.data.local.MovieLocalDataSource;
import com.project.osg.finalprojectosg11.data.remote.MovieRemoteDataSource;
import com.project.osg.finalprojectosg11.model.Movie;

public class MovieRepository implements MovieDataSource {

    private MovieLocalDataSource movieLocalDataSource;
    private MovieRemoteDataSource movieRemoteDataSource;

    public MovieRepository(MovieRemoteDataSource movieRemoteDataSource, MovieLocalDataSource movieLocalDataSource) {
        this.movieRemoteDataSource= movieRemoteDataSource;
        this.movieLocalDataSource = movieLocalDataSource;
    }

    @Override
    public void getListMovies(final GetMoviesCallback callback) {
        movieLocalDataSource.getListMovies(new GetMoviesCallback() {
            @Override
            public void onMovieLoaded(Movie data) {
                callback.onMovieLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                getMovieFromRemoteDataSource(callback);
            }
        });
    }


    private void getMovieFromRemoteDataSource(final GetMoviesCallback callback) {

        movieRemoteDataSource.getListMovies(new GetMoviesCallback() {
            @Override
            public void onMovieLoaded(Movie data) {
                callback.onMovieLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);
            }
        });
    }
}
