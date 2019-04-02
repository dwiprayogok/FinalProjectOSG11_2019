package com.project.osg.finalprojectosg11.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.project.osg.finalprojectosg11.model.MovieDetail;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM Film")
    List<MovieDetail> getMovie();

    @Insert
    void insertMovie(List<MovieDetail> movie);
}
