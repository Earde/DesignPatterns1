package com.company.Controllers;

import com.company.Models.Movie;
import com.company.Models.ObservableList;
import com.company.Views.ChartView;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface IChartMovie {
    default void updateChart(ChartView view, ObservableList<Movie> movies) {
        view.getChart().getCategoryPlot().setDataset(createDataset(movies));
        view.getPanel().revalidate();
        view.getPanel().repaint();
    }

    private DefaultCategoryDataset createDataset(ObservableList<Movie> movies) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        List<String> origins = new ArrayList<>();
        movies.getAll().stream().forEach(m -> origins.add(m.getOrigin())); // Stream & lambda
        origins.stream().forEach(o -> dataSet.setValue(Collections.frequency(origins, o), o, o)); // Stream & lambda
        return dataSet;
    }
}
