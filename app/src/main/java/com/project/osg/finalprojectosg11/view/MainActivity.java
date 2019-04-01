package com.project.osg.finalprojectosg11.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.project.osg.finalprojectosg11.adapter.MovieAdapter;
import com.project.osg.finalprojectosg11.adapter.PeopleAdapter;
import com.project.osg.finalprojectosg11.model.Movie;
import com.project.osg.finalprojectosg11.model.MovieDetail;
import com.project.osg.finalprojectosg11.model.PeopleDetail;
import com.project.osg.finalprojectosg11.navigator.MovieNavigator;
import com.project.osg.finalprojectosg11.navigator.PeopleNavigator;
import com.project.osg.finalprojectosg11.viewmodel.MovieViewModel;
import com.project.osg.finalprojectosg11.viewmodel.PeopleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PeopleNavigator {
    String TAG = "MainActivity";
    private PeopleViewModel peopleViewModel;
    private RecyclerView recyclerview;

    private PeopleAdapter adapter;
    private List<PeopleDetail> dataListPeople;

    private PeopleDetail listPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview =findViewById(R.id.rcyclerview);
        peopleViewModel= new PeopleViewModel(Injection.providePeopleRepository(this), this);
        dataListPeople= new ArrayList<>();
        peopleViewModel.setNavigator(this);
        peopleViewModel.getListPeople();
        initAdapter();
    }

    private void initAdapter() {
        adapter = new PeopleAdapter(dataListPeople);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.addItemDecoration(new DividerItemDecoration(this,   DividerItemDecoration.VERTICAL));
        recyclerview.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerview, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                listPeople = dataListPeople.get(position);
//                Intent intent = new Intent(getApplicationContext(), Detail_refund.class);
//                intent.putExtra("name", listPeople.getName()); //you can name the keys whatever you like
//
//                startActivity(intent);
                Log.d(TAG, "onClick: "+ listPeople.getName() );
                Toast.makeText(getApplicationContext()," Namanya adalah "+ listPeople.getName(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void loadListPeople(List<PeopleDetail> listPeople) {
        dataListPeople.addAll(listPeople);
        adapter.notifyDataSetChanged();

        Log.i("list People", String.valueOf(listPeople));
    }

    @Override
    public void errorLoadListPeople(String message) {
        Log.e("ERROR", message);
    }


    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
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
