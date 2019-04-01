package com.project.osg.finalprojectosg11.viewmodel;

import android.content.Context;

import com.project.osg.finalprojectosg11.data.PeopleDataSource;
import com.project.osg.finalprojectosg11.data.PeopleRepository;
import com.project.osg.finalprojectosg11.model.People;
import com.project.osg.finalprojectosg11.navigator.PeopleNavigator;

public class PeopleViewModel {
    private PeopleRepository peopleRepository;
    private Context context;
    private PeopleNavigator peopleNavigator;


    public PeopleViewModel(PeopleRepository peopleRepository,Context context){
        this.peopleRepository = peopleRepository;
        this.context=context;
    }

    public void setNavigator(PeopleNavigator navigator) {
        peopleNavigator = navigator;
    }


    public void getListPeople(){
        peopleRepository.getListPeople(new PeopleDataSource.GetPeopleCallback() {
            @Override
            public void onPeopleLoaded(People data) {
                peopleNavigator.loadListPeople(data.getPeople());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                peopleNavigator.errorLoadListPeople(errorMessage);
            }
        });
    }
}
