package com.project.osg.finalprojectosg11.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Poeples implements Serializable {

    @SerializedName("next")
    private String next;

    @SerializedName("previous")
    private Object previous;

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private List<ResultsItem> results;

    public void setNext(String next){
        this.next = next;
    }

    public String getNext(){
        return next;
    }

    public void setPrevious(Object previous){
        this.previous = previous;
    }

    public Object getPrevious(){
        return previous;
    }

    public void setCount(int count){
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    public void setResults(List<ResultsItem> results){
        this.results = results;
    }

    public List<ResultsItem> getResults(){
        return results;
    }

    @Override
    public String toString(){
        return
                "Poeples{" +
                        "next = '" + next + '\'' +
                        ",previous = '" + previous + '\'' +
                        ",count = '" + count + '\'' +
                        ",results = '" + results + '\'' +
                        "}";
    }
}
