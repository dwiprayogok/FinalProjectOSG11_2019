package com.project.osg.finalprojectosg11.data;

import com.project.osg.finalprojectosg11.model.People;

public interface PeopleDataSource {

    void getListPeople(GetPeopleCallback callback);

    interface   GetPeopleCallback{
        void onPeopleLoaded(People data);
        void onDataNotAvailable(String errorMessage);
    }

}
