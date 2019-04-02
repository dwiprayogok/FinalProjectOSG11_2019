package com.project.osg.finalprojectosg11.data.local;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.project.osg.finalprojectosg11.model.PeopleDetail;

import java.util.List;

public interface PeopleDao {

    @Query("SELECT * FROM people")
    List<PeopleDetail> getPeople();

    @Insert
    void insertPeople(List<PeopleDetail> people);
}
