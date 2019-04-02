package com.project.osg.finalprojectosg11.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.project.osg.finalprojectosg11.R;

public class Detail_Activity extends AppCompatActivity {

    private TextView txtTitle, txtEpisode, txtSpoiler,txtProducer, txtDirector, txtReleaseDate;
    private Bundle bundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);
        initViews();
        bundle = getIntent().getExtras();
        showDetailFromBundle();
    }

    private void initViews(){
        txtTitle = findViewById(R.id.judul);
        txtEpisode = findViewById(R.id.episode);
        txtSpoiler = findViewById(R.id.isi);
        txtProducer = findViewById(R.id.producer);
        txtDirector = findViewById(R.id.director);
        txtReleaseDate = findViewById(R.id.tanggal_release);
    }

    private void showDetailFromBundle(){
        String sTitle = bundle.getString(ListMovieActivity.TAG_TITLE);
        String sEpisode = bundle.getString(ListMovieActivity.TAG_EPISODE);
        String sSpoiler = bundle.getString(ListMovieActivity.TAG_OPENING_CRAWL);
        String sDirector = bundle.getString(ListMovieActivity.TAG_DIRECTOR);
        String sProducer = bundle.getString(ListMovieActivity.TAG_PRODUCER);
        String sReleaseDate = bundle.getString(ListMovieActivity.TAG_RELEASE);

        txtTitle.setText(sTitle);
        txtSpoiler.setText(sSpoiler);
        txtEpisode.setText("Episode : "+sEpisode);
        txtDirector.setText("Producer by : "+sDirector);
        txtProducer.setText("Director by : "+sProducer);
        txtReleaseDate.setText("Release date : "+sReleaseDate);
    }
}
