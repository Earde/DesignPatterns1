package com.company.Controllers;
import com.company.Controllers.Interfaces.IAddMovie;
import com.company.Controllers.Interfaces.IChartMovie;
import com.company.Controllers.Interfaces.ICustomFunction;
import com.company.Controllers.Interfaces.IListMovies;
import com.company.Models.Movie;
import com.company.Models.ObservableListModel;
import com.company.Views.AddView;
import com.company.Views.ChartView;
import com.company.Views.ListView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

//Controller & Observer (Split into multiple interfaces for readable code)
public class MovieController implements Observer, IAddMovie, IListMovies, IChartMovie {
    private ObservableListModel<Movie> movies;
    private AddView addView;
    private ChartView chartView;
    private ListView listView;

    public MovieController(AddView addView, ChartView chartView, ListView listView, ObservableListModel<Movie> movies) {
        // Dependency injections
        this.movies = movies;
        this.addView = addView;
        this.chartView = chartView;
        this.listView = listView;

        // Add observer
        this.movies.addObserver(this);

        // Textfields validation
        this.addView.setNameTextFieldAction(new MovieController.ValidateAction(() -> handleTextField(this.addView.getNameTextField(), this.addView, isTextValid(this.addView.getNameTextField())))); //Lambda
        this.addView.setOriginTextFieldAction(new MovieController.ValidateAction(() -> handleTextField(this.addView.getOriginTextField(), this.addView, isTextValid(this.addView.getOriginTextField())))); //Lambda
        this.addView.setYearTextFieldAction(new MovieController.ValidateAction(() -> handleTextField(this.addView.getYearTextField(), this.addView, isYearValid(this.addView.getYearTextField())))); //Lambda
        this.addView.setBudgetTextFieldAction(new MovieController.ValidateAction(() -> handleTextField(this.addView.getBudgetTextField(), this.addView, isBudgetValid(this.addView.getBudgetTextField())))); //Lambda

        // Save movie
        this.addView.setSaveButtonAction(new MovieController.AddAction());

        // Disable save button because inputs are empty at start of program
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
    class AddAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            saveMovie(addView, movies);
            addView.getSaveButton().setEnabled(isSavable(addView));
        }
    }

    class ValidateAction extends AbstractAction {
        ICustomFunction function;
        public ValidateAction(ICustomFunction func) {
            function = func;
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            function.execute();
        } //Execute lambda
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