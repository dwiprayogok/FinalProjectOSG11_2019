package com.project.osg.finalprojectosg11.data.local;

import android.content.Context;

import com.project.osg.finalprojectosg11.data.PeopleDataSource;
import com.project.osg.finalprojectosg11.model.People;
import com.project.osg.finalprojectosg11.model.PeopleDetail;

import java.util.List;

public class PeopleLocalDataSource implements PeopleDataSource {
    private Context context;
    private PeopleDao peopleDao;

    public PeopleLocalDataSource(Context context){
        this.context = context;
        peopleDao = PeopleDataBase.getInstance(context).peopleDao();
    }


    @Override
    public void getListPeople(final PeopleDataSource.GetPeopleCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<PeopleDetail> people = peopleDao.getPeople();
                if (people.isEmpty()){
                    callback.onDataNotAvailable("Data Lokal Kosong");
                }else{
                    People peoples = new People(people);
                    callback.onPeopleLoaded(peoples);
                }
            }
        };
        new Thread(runnable).start();
    }


    public void saveDataPeople(final List<PeopleDetail> peopleDetail){
        Runnable runnable= new Runnable() {
            @Override
            public void run() {
                peopleDao.insertPeople(peopleDetail);
            }
        };
        new Thread(runnable).start();
    }
}
