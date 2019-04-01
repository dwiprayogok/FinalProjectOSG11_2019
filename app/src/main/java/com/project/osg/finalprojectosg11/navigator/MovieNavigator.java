package com.project.osg.finalprojectosg11.navigator;

import com.project.osg.finalprojectosg11.model.MovieDetail;

import java.util.List;

public interface MovieNavigator {


    void loadListTeam(List<MovieDetail> listMovie);
    void errorLoadListMovie(String message);
}
