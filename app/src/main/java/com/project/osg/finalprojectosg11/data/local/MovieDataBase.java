package com.project.osg.finalprojectosg11.data.local;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

public abstract class MovieDataBase extends RoomDatabase {

    private static MovieDataBase INSTANCE;

    public abstract MovieDao movieDao();

    private static final Object sLock = new Object();

    public static MovieDataBase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        MovieDataBase.class, "People.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}
