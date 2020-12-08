package com.company.Controllers.Interfaces;

import com.company.Models.MovieEntity;
import com.company.Models.ObservableListModel;
import com.company.Views.ChartView;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface IChartMovie {
    // Repaint Chart
    default void updateChart(ChartView view, ObservableListModel<MovieEntity> movies) {
        view.getChart().getCategoryPlot().setDataset(createDataset(movies));
        view.getPanel().revalidate();
        view.getPanel().repaint();
    }

    // 1. Create EmptyJFree Dataset
    // 2. Add movies
    // 3. Add frequency of origin to Chart
    private DefaultCategoryDataset createDataset(ObservableListModel<MovieEntity> movies) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        List<String> origins = new ArrayList<>();
        movies.getAll().stream().forEach(m -> origins.add(m.getOrigin())); // Stream & lambda
        origins.stream().forEach(o -> dataSet.setValue(Collections.frequency(origins, o), o, o)); // Stream & lambda
        return dataSet;
    }
}
