package com.project.osg.finalprojectosg11.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "people")
public class PeopleDetail {

    @PrimaryKey(autoGenerate = true)
    public int mId;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    public String name;


    @ColumnInfo(name = "height")
    @SerializedName("height")
    public  String height;

    @ColumnInfo(name = "mass")
    @SerializedName("mass")
    public  String mass;

    @ColumnInfo(name  = "gender")
    @SerializedName("gender")
    public  String Gender;

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getGender() {
        return Gender;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }
}
