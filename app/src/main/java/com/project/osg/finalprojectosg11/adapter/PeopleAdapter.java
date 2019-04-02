package com.project.osg.finalprojectosg11.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.osg.finalprojectosg11.R;
import com.project.osg.finalprojectosg11.model.PeopleDetail;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleHolder> {

    private List<PeopleDetail> listpeople;

    public PeopleAdapter(List<PeopleDetail> listPeople){
        this.listpeople = listPeople;
    }

    @NonNull
    @Override
    public PeopleAdapter.PeopleHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_movie,viewGroup,false);
        return new PeopleAdapter.PeopleHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleAdapter.PeopleHolder peopleHolder, int i) {
        PeopleDetail data = listpeople.get(i);
        peopleHolder.tvPeopleName.setText("Namanya adalah :" + data.getName());
        peopleHolder.tvGender.setText("Jenis Kelamin :" + data.getGender());
        peopleHolder.tvHeight.setText("Tingginya adalah :" + data.getHeight());
        peopleHolder.tvMass.setText("Berat Badan nya adalah :" + data.getMass());

    }

    @Override
    public int getItemCount() {
        return listpeople.size();
    }

    public class PeopleHolder extends RecyclerView.ViewHolder {
        TextView tvPeopleName ;
        TextView tvGender;
        TextView tvHeight ;
        TextView tvMass;
        public PeopleHolder(@NonNull View itemView) {
            super(itemView);
            tvPeopleName = itemView.findViewById(R.id.tvPeopleName);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvHeight = itemView.findViewById(R.id.tvHeight);
            tvMass = itemView.findViewById(R.id.tvMass);
        }
    }
}
