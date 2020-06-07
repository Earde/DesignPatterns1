package com.company.Controllers;
import com.company.Models.Movie;
import com.company.Models.ObservableList;
import com.company.Views.AddView;
import com.company.Views.ChartView;
import com.company.Views.ListView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class MovieController implements Observer, IAddMovie, IListMovies, IChartMovie {
    private ObservableList<Movie> movies;
    private AddView addView;
    private ChartView chartView;
    private ListView listView;

    public MovieController(AddView addView, ChartView chartView, ListView listView, ObservableList<Movie> movies) {
        // Dependency injections
        this.movies = movies;
        this.addView = addView;
        this.chartView = chartView;
        this.listView = listView;
        // Add observer
        this.movies.addObserver(this);
        // Textfields validation
        this.addView.setNameTextFieldAction(new ValidateAction(this.addView.getNameTextField(), (tf) -> handleTextField(tf, this.addView, isTextValid(tf))));
        this.addView.setOriginTextFieldAction(new ValidateAction(this.addView.getOriginTextField(), (tf) -> handleTextField(tf, this.addView, isTextValid(tf))));
        this.addView.setYearTextFieldAction(new ValidateAction(this.addView.getYearTextField(), (tf) -> handleTextField(tf, this.addView, isYearValid(tf))));
        this.addView.setBudgetTextFieldAction(new ValidateAction(this.addView.getBudgetTextField(), (tf) -> handleTextField(tf, this.addView, isBudgetValid(tf))));
        // Save movie
        this.addView.setSaveButtonAction(new AddAction());
        // Disable save button because they are empty at start
        this.addView.getSaveButton().setEnabled(isSavable(addView));
        // Delete item action
        this.listView.setDeleteButtonAction(new DeleteAction());
        // Info about item action
        this.listView.setInfoButtonAction(new InfoAction());
    }

    // On model changed
    @Override
    public void update(Observable observable, Object o) {
        updateList(this.listView, this.movies);
        updateChart(this.chartView, this.movies);
    }

    // COMMAND PATTERNS
    class ValidateAction extends AbstractAction {
        JTextField textField;
        ICustomFunction function;
        public ValidateAction(JTextField tf, ICustomFunction func) {
            function = func;
            textField = tf;
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            function.execute(textField);
        }
    }

    class AddAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            saveMovie(addView, movies);
            addView.getSaveButton().setEnabled(isSavable(addView));
        }
    }

    class DeleteAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            deleteItem(listView, movies);
        }
    }

    class InfoAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            infoAboutItem(listView, movies);
        }
    }
}