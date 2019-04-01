package com.project.osg.finalprojectosg11.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.osg.finalprojectosg11.R;
import com.project.osg.finalprojectosg11.model.MovieDetail;

import java.util.List;

public class MovieAdapter  extends RecyclerView.Adapter<MovieAdapter.PeopleHolder> {

    private List<MovieDetail> listMovie;

    public MovieAdapter(List<MovieDetail> listPeople){
        this.listMovie = listPeople;
    }

    @NonNull
    @Override
    public MovieAdapter.PeopleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_movie,viewGroup,false);
        return new MovieAdapter.PeopleHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.PeopleHolder peopleHolder, int i) {
        MovieDetail data = listMovie.get(i);
        peopleHolder.tvPeopleName.setText(data.getName());
        peopleHolder.tvGender.setText(data.getGender());

    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class PeopleHolder extends RecyclerView.ViewHolder {
        TextView tvPeopleName ;
        TextView tvGender;
        public PeopleHolder(@NonNull View itemView) {
            super(itemView);
            tvPeopleName = itemView.findViewById(R.id.tvPeopleName);
            tvGender = itemView.findViewById(R.id.tvGender);
        }
    }
}
