package com.project.osg.finalprojectosg11.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.project.osg.finalprojectosg11.model.PeopleDetail;


@Database(entities = {PeopleDetail.class}, version = 1,exportSchema = false)
public abstract class PeopleDataBase extends RoomDatabase {

    private static PeopleDataBase INSTANCE;

    public abstract PeopleDao peopleDao();

    private static final Object sLock = new Object();

    public static PeopleDataBase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        PeopleDataBase.class, "People.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}
