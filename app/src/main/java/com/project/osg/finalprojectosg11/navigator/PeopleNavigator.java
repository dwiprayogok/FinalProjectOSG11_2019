package com.project.osg.finalprojectosg11.navigator;

import com.project.osg.finalprojectosg11.model.PeopleDetail;

import java.util.List;

public interface PeopleNavigator {

    void loadListPeople(List<PeopleDetail> listPeople);
    void errorLoadListPeople(String message);
}
