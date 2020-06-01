package com.company.Controllers;

import com.company.Models.Movie;
import com.company.Views.ChartView;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface IChartMovie {
    default void initChartMovie(ChartView view, ObservableList<Movie> movies) {
        setModelChangedListener(view, movies);
    }

    default void setModelChangedListener(ChartView view, ObservableList<Movie> movies) {
        movies.addListener((ListChangeListener<Movie>) change -> {
            view.getChart().getCategoryPlot().setDataset(createDataset(movies));
            view.getPanel().revalidate();
            view.getPanel().repaint();
        });
    }

    default DefaultCategoryDataset createDataset(ObservableList<Movie> movies) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        List<String> origins = new ArrayList<>();
        movies.stream().forEach(m -> origins.add(m.getOrigin())); // Stream & lambda
        origins.stream().forEach(o -> dataSet.setValue(Collections.frequency(origins, o), o, o)); // Stream & lambda
        return dataSet;
    }
}
