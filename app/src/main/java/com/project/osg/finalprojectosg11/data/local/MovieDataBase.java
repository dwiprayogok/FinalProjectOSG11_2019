package com.project.osg.finalprojectosg11.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.project.osg.finalprojectosg11.model.MovieDetail;


@Database(entities = {MovieDetail.class}, version = 1,exportSchema = false)
public abstract class MovieDataBase extends RoomDatabase {

    private static MovieDataBase INSTANCE;

    public abstract MovieDao movieDao();

    private static final Object sLock = new Object();

    public static MovieDataBase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        MovieDataBase.class, "Film.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}
