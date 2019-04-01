package com.project.osg.finalprojectosg11.data;

import com.project.osg.finalprojectosg11.data.local.PeopleLocalDataSource;
import com.project.osg.finalprojectosg11.data.remote.PeopleRemoteDataSource;
import com.project.osg.finalprojectosg11.model.People;

public class PeopleRepository implements PeopleDataSource{

    private PeopleLocalDataSource peopleLocalDataSource;
    private PeopleRemoteDataSource peopleRemoteDataSource;

    public PeopleRepository(PeopleRemoteDataSource peopleRemoteDataSource, PeopleLocalDataSource peopleLocalDataSource){
        this.peopleRemoteDataSource= peopleRemoteDataSource;
        this.peopleLocalDataSource = peopleLocalDataSource;
    }


    @Override
    public void getListPeople(final GetPeopleCallback callback) {
        peopleLocalDataSource.getListPeople(new GetPeopleCallback() {
            @Override
            public void onPeopleLoaded(People data) {
                callback.onPeopleLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                getPeopleFromRemoteDataSource(callback);
            }
        });
    }

    private void getPeopleFromRemoteDataSource(final GetPeopleCallback callback) {

        peopleRemoteDataSource.getListPeople(new GetPeopleCallback() {
            @Override
            public void onPeopleLoaded(People data) {
                callback.onPeopleLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);
            }
        });
    }
}
