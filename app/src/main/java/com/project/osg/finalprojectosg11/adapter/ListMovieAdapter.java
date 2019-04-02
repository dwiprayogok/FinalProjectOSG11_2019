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

public class ListMovieAdapter  extends RecyclerView.Adapter<ListMovieAdapter.PeopleHolder> {

    private List<MovieDetail> listpeople;

    public ListMovieAdapter(List<MovieDetail> listPeople){
        this.listpeople = listPeople;
    }

    @NonNull
    @Override
    public ListMovieAdapter.PeopleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_listmovie,viewGroup,false);
        return new ListMovieAdapter.PeopleHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMovieAdapter.PeopleHolder peopleHolder, int i) {
        MovieDetail data = listpeople.get(i);
        peopleHolder.tvTitle.setText("Judul Film : " + data.getTitle());
        peopleHolder.tvDirectur.setText("Director : " + data.getDirector());
        peopleHolder.tvProducre.setText("Producer : " + data.getProducer() );
        peopleHolder.tvDate.setText("Tanggal Release : " + data.getRelease_date() );

    }

    @Override
    public int getItemCount() {
        return listpeople.size();
    }

    public class PeopleHolder extends RecyclerView.ViewHolder {
        TextView tvTitle ;
        TextView tvDirectur;
        TextView tvProducre ;
        TextView tvDate;
        public PeopleHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDirectur = itemView.findViewById(R.id.tvDirectur);
            tvProducre = itemView.findViewById(R.id.tvProducre);
            tvDate = itemView.findViewById(R.id.tvDate);
        }
    }
}
