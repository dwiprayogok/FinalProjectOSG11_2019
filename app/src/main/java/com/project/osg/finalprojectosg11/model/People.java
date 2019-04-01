package com.project.osg.finalprojectosg11.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class People {

    @SerializedName("results")
    List<PeopleDetail> peoples;

    public People(List<PeopleDetail> peoples) {
        this.peoples = peoples;
    }

    public List<PeopleDetail> getPeople() {
        return peoples;
    }
}
