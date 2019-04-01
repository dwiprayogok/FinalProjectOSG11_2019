package com.project.osg.finalprojectosg11.data.local;

import android.content.Context;

import com.project.osg.finalprojectosg11.data.MovieDataSource;
import com.project.osg.finalprojectosg11.model.Movie;
import com.project.osg.finalprojectosg11.model.MovieDetail;

import java.util.List;

public class MovieLocalDataSource  implements MovieDataSource {

    private Context context;
    private MovieDao movieDao;

    public MovieLocalDataSource(Context context) {
        this.context = context;
        movieDao = MovieDataBase.getInstance(context).movieDao();
    }

    @Override
    public void getListMovies(final GetMoviesCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<MovieDetail> people = movieDao.getMovie();
                if (people.isEmpty()){
                    callback.onDataNotAvailable("Data Lokal Kosong");
                }else{
                    Movie peoples = new Movie(people);
                    callback.onMovieLoaded(peoples);
                }
            }
        };
        new Thread(runnable).start();
    }


    public void saveDataMovie(final List<MovieDetail> movieDetail){
        Runnable runnable= new Runnable() {
            @Override
            public void run() {
                movieDao.insertMovie(movieDetail);
            }
        };
        new Thread(runnable).start();
    }
}
