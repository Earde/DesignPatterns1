package com.company;

import com.company.Controllers.MovieController;
import com.company.Models.Movie;
import com.company.Views.AbstractView;
import com.company.Views.ViewFactory;
import com.company.Views.ViewTypes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        List<AbstractView> views = new ArrayList<>();
        // Create Views
        views.add(ViewFactory.createView(ViewTypes.ADD));
        views.add(ViewFactory.createView(ViewTypes.CHART));
        views.add(ViewFactory.createView(ViewTypes.LIST));
        // Create Controller
        MovieController c = MovieController.getInstance();
        c.initController(views, movies);
    }
}