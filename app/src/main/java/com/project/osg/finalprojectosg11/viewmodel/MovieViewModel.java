package com.project.osg.finalprojectosg11.viewmodel;

import android.content.Context;

import com.project.osg.finalprojectosg11.data.MovieDataSource;
import com.project.osg.finalprojectosg11.data.MovieRepository;
import com.project.osg.finalprojectosg11.model.Movie;
import com.project.osg.finalprojectosg11.navigator.MovieNavigator;

public class MovieViewModel {
    private MovieRepository movieRepository;
    private Context context;
    private MovieNavigator movieNavigator;


    public MovieViewModel(MovieRepository movieRepository,Context context){
        this.movieRepository = movieRepository;
        this.context=context;
    }

    public void setNavigator(MovieNavigator navigator) {
        movieNavigator = navigator;
    }


    public void getListPeople(){
        movieRepository.getListMovies(new MovieDataSource.GetMoviesCallback() {
            @Override
            public void onMovieLoaded(Movie data) {
                movieNavigator.loadListTeam(data.getFilms());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                movieNavigator.errorLoadListMovie(errorMessage);
            }
        });
    }
}
