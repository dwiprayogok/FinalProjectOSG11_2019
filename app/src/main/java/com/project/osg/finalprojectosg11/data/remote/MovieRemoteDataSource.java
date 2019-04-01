package com.project.osg.finalprojectosg11.data.remote;

import com.project.osg.finalprojectosg11.data.MovieDataSource;
import com.project.osg.finalprojectosg11.model.Movie;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRemoteDataSource implements MovieDataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListMovies(final GetMoviesCallback callback) {
        Call<Movie> call = apiInterface.getAllPeople();
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                callback.onMovieLoaded(response.body());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                callback.onDataNotAvailable(t.toString());
            }
        });
    }
}
