package com.company;

import com.company.Controllers.MovieController;
import com.company.Models.Movie;
import com.company.Models.ObservableList;
import com.company.Views.*;

public class Main {
    public static void main(String[] args) {
        ObservableList<Movie> movies = new ObservableList();
        // Create Controller
        MovieController c = new MovieController(
                (AddView)ViewFactory.createView(ViewTypes.ADD),
                (ChartView)ViewFactory.createView(ViewTypes.CHART),
                (ListView)ViewFactory.createView(ViewTypes.LIST),
                movies);
    }
}