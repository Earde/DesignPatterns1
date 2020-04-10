package com.company.Controllers;
import com.company.Models.Movie;
import com.company.Views.AbstractView;
import com.company.Views.AddView;
import com.company.Views.ChartView;
import com.company.Views.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Controller implements IAddMovie, IListMovies, IChartMovie {
    private ObservableList<Movie> movies;

    // Singleton pattern
    private static final Controller instance = new Controller();
    private Controller() { }
    public static Controller getInstance() { return instance; }

    // Initialize controller
    public void initController(List<AbstractView> views, List<Movie> movies) {
        this.movies =  FXCollections.observableArrayList(movies); // Dependency injection
        for (AbstractView view : views) {
            view.init(); // Initialize view
            init(view); // Set listeners on UI elements
        }
    }

    // Set action listeners for each view
    private void init(AbstractView view) {
        if (view instanceof AddView) {
            init((AddView)view, movies);
        } else if (view instanceof ListView) {
            init((ListView)view, movies);
        } else if (view instanceof ChartView) {
            init((ChartView)view, movies);
        } else {
            throw new Error("Please create an init(" + view.getClass().getSimpleName() + " view, movies) function");
        }
    }
}