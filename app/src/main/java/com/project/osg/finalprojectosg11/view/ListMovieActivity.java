package com.project.osg.finalprojectosg11.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.project.osg.finalprojectosg11.Injection;
import com.project.osg.finalprojectosg11.R;
import com.project.osg.finalprojectosg11.adapter.ListMovieAdapter;
import com.project.osg.finalprojectosg11.adapter.PeopleAdapter;
import com.project.osg.finalprojectosg11.model.MovieDetail;
import com.project.osg.finalprojectosg11.model.PeopleDetail;
import com.project.osg.finalprojectosg11.navigator.MovieNavigator;
import com.project.osg.finalprojectosg11.navigator.PeopleNavigator;
import com.project.osg.finalprojectosg11.viewmodel.MovieViewModel;
import com.project.osg.finalprojectosg11.viewmodel.PeopleViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListMovieActivity extends AppCompatActivity implements MovieNavigator {

    String TAG = "ListMovieActivity";
    private MovieViewModel movieViewModel;
    private RecyclerView recyclerview;

    private ListMovieAdapter adapter;
    private List<MovieDetail> dataListMovie;

    private MovieDetail movieDetail;

    public static final String TAG_TITLE = "TITLE";
    public static final String TAG_EPISODE = "EPISODE";
    public static final String TAG_OPENING_CRAWL = "OPENING_CRAWL";
    public static final String TAG_DIRECTOR = "DIRECTOR";
    public static final String TAG_PRODUCER = "PRODUCER";
    public static final String TAG_RELEASE = "RELEASE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listmovie_activity);

        recyclerview =findViewById(R.id.rcyclerview_listmovie);
        movieViewModel= new MovieViewModel(Injection.provideMovieRepository(this), this);
        dataListMovie= new ArrayList<>();
        movieViewModel.setNavigator(this);
        movieViewModel.getListPeople();
        initAdapter();
    }
    private void initAdapter() {
        adapter = new ListMovieAdapter(dataListMovie);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.addItemDecoration(new DividerItemDecoration(this,   DividerItemDecoration.VERTICAL));
        recyclerview.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerview, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                movieDetail = dataListMovie.get(position);
                Bundle bundle = new Bundle();
                bundle.putString(TAG_TITLE, movieDetail.title);
                bundle.putString(TAG_EPISODE, movieDetail.episode_id);
                bundle.putString(TAG_OPENING_CRAWL, movieDetail.opening_crawl);
                bundle.putString(TAG_DIRECTOR, movieDetail.director);
                bundle.putString(TAG_PRODUCER, movieDetail.producer);
                bundle.putString(TAG_RELEASE, movieDetail.release_date);
//                intent.putExtra("name", listPeople.getName()); //you can name the keys whatever you like
                startActivity(new Intent(getApplicationContext(), Detail_Activity.class).putExtras(bundle));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void loadListTeam(List<MovieDetail> listPeople) {
        dataListMovie.addAll(listPeople);
        adapter.notifyDataSetChanged();

        Log.i("list People", String.valueOf(listPeople));
    }

    @Override
    public void errorLoadListMovie(String message) {
        Log.e("ERROR", message);
    }


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ListMovieActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ListMovieActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
