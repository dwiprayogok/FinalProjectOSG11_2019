package com.project.osg.finalprojectosg11;

import android.content.Context;

import com.project.osg.finalprojectosg11.data.MovieRepository;
import com.project.osg.finalprojectosg11.data.PeopleRepository;
import com.project.osg.finalprojectosg11.data.local.MovieLocalDataSource;
import com.project.osg.finalprojectosg11.data.local.PeopleLocalDataSource;
import com.project.osg.finalprojectosg11.data.remote.MovieRemoteDataSource;
import com.project.osg.finalprojectosg11.data.remote.PeopleRemoteDataSource;

public class Injection {

    public static MovieRepository provideMovieRepository(Context context){
        return new MovieRepository(new MovieRemoteDataSource(), new MovieLocalDataSource(context));
    }

    public static PeopleRepository providePeopleRepository(Context context) {
        return new PeopleRepository(new PeopleRemoteDataSource(), new PeopleLocalDataSource(context));
    }
}
