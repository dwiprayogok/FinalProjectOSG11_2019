package com.project.osg.finalprojectosg11.data.remote;

import com.project.osg.finalprojectosg11.data.PeopleDataSource;
import com.project.osg.finalprojectosg11.model.People;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleRemoteDataSource  implements PeopleDataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListPeople(final GetPeopleCallback callback) {
        Call<People> call = apiInterface.getAllPeople();
        call.enqueue(new Callback<People>() {
            @Override
            public void onResponse(Call<People> call, Response<People> response) {
                callback.onPeopleLoaded(response.body());
            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {
                callback.onDataNotAvailable(t.toString());
            }
        });
    }
}
