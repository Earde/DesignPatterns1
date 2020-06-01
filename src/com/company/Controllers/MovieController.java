package com.company.Controllers;
import com.company.Models.Movie;
import com.company.Views.AbstractView;
import com.company.Views.AddView;
import com.company.Views.ChartView;
import com.company.Views.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class MovieController implements IAddMovie, IListMovies, IChartMovie {
    private ObservableList<Movie> movies;

    // Singleton pattern
    private static final MovieController instance = new MovieController();
    private MovieController() { }
    public static MovieController getInstance() { return instance; }

    // Initialize controller
    public void initController(List<AbstractView> views, List<Movie> movies) {
        this.movies =  FXCollections.observableArrayList(movies); // Dependency injection
        for (AbstractView view : views) {
            if (view != null) {
                view.init(); // Initialize view
                init(view); // Set listeners on UI elements
            }
        }
    }

    // Set action listeners for each view
    private void init(AbstractView view) {
        // Ik wou eigenlijk geen if else lijst, maar het was dit, of meerdere controller instanties (een voor list, een voor chart etc.) met polymorphism.
        // Volgens mij is het niet de bedoeling om meerdere controller instanties te maken voor een mvc component.
        // Daarom toch hier voor gekozen.
        // Als u nog een tip heeft hoe dit generieker kan i.c.m. een enkele controller instantie, dan hoor ik het graag.
        if (view instanceof AddView) {
            initAddMovie((AddView)view, movies);
        } else if (view instanceof ListView) {
            initListMovie((ListView)view, movies);
        } else if (view instanceof ChartView) {
            initChartMovie((ChartView)view, movies);
        } else {
            throw new Error("Please create an init(" + view.getClass().getSimpleName() + " view, movies) function");
        }
    }
}