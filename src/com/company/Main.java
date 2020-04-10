package com.company;

import com.company.Controllers.Controller;
import com.company.Models.Movie;
import com.company.Views.AbstractView;
import com.company.Views.ViewFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        List<AbstractView> views = new ArrayList<>();
        // Create Views
        views.add(ViewFactory.getView("ADD"));
        views.add(ViewFactory.getView("LIST"));
        views.add(ViewFactory.getView("CHART"));
        // Create Controller
        Controller c = Controller.getInstance();
        c.initController(views, movies);
    }
}