package com.project.osg.finalprojectosg11.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Film")
public class MovieDetail {

    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    public String title;


    @ColumnInfo(name = "episode_id")
    @SerializedName("episode_id")
    public  String episode_id;

    @ColumnInfo(name = "opening_crawl")
    @SerializedName("opening_crawl")
    public  String opening_crawl;

    @ColumnInfo(name  = "director")
    @SerializedName("director")
    public  String director;


    @ColumnInfo(name  = "producer")
    @SerializedName("producer")
    public  String producer;


    @ColumnInfo(name  = "release_date")
    @SerializedName("release_date")
    public  String release_date;


    public void setDirector(String director) {
        this.director = director;
    }

    public void setEpisode_id(String episode_id) {
        this.episode_id = episode_id;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getmId() {
        return mId;
    }

    public String getDirector() {
        return director;
    }

    public String getEpisode_id() {
        return episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public String getProducer() {
        return producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getTitle() {
        return title;
    }

}
