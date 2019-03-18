package com.project.osg.finalprojectosg11;

import android.content.Context;

import com.project.osg.finalprojectosg11.data.MovieRepository;
import com.project.osg.finalprojectosg11.data.local.MovieLocalDataSource;
import com.project.osg.finalprojectosg11.data.remote.MovieRemoteDataSource;

public class Injection {

    public static MovieRepository provideMovieRepository(Context context){
        return new MovieRepository(new MovieRemoteDataSource(), new MovieLocalDataSource(context));
    }
}
