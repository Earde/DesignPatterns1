package com.company.Controllers;
import com.company.Models.Movie;
import com.company.Views.View;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Controller implements IAddMovie {
    private List<Movie> movies;
    private View view;

    private static final Controller instance = new Controller();
    private Controller() { }
    public static Controller getInstance() { return instance; }

    public void initController(View v) {
        movies = new ArrayList<Movie>();
        view = v; //dependency injection
        initAddMovie();
    }

    @Override
    public void initAddMovie() {
        //set input changed listeners with custom function
        setIsValidInputListener((tf) -> handleTextField(tf, view.getSaveButton(), isTextValid(tf)), view.getOriginTextField());
        setIsValidInputListener((tf) -> handleTextField(tf, view.getSaveButton(), isYearValid(tf)), view.getYearTextField());
        setIsValidInputListener((tf) -> handleTextField(tf, view.getSaveButton(), isBudgetValid(tf)), view.getBudgetTextField());
        setIsValidInputListener((tf) -> handleTextField(tf, view.getSaveButton(), isTextValid(tf)), view.getNameTextField());
        view.getSaveButton().addActionListener(e -> saveMovie());
        view.getSaveButton().setEnabled(isSavable());
    }

    @Override
    public boolean isSavable() {
        return isBudgetValid(view.getBudgetTextField()) && isTextValid(view.getBudgetTextField()) && isTextValid(view.getBudgetTextField()) && isYearValid(view.getBudgetTextField());
    }

    @Override
    public void saveMovie() {
        if (isSavable()) { //not necessary because saveButton will get disabled if not savable
            String name = view.getNameTextField().getText();
            String origin = view.getOriginTextField().getText();
            double budget = Double.parseDouble(view.getBudgetTextField().getText());
            int year = Integer.parseInt(view.getYearTextField().getText());
            movies.add(new Movie(name, year, origin, budget));
            view.getNameTextField().setText("");
            view.getOriginTextField().setText("");
            view.getYearTextField().setText("");
            view.getBudgetTextField().setText("");
            view.getNameTextField().setBackground(Color.WHITE);
            view.getOriginTextField().setBackground(Color.WHITE);
            view.getYearTextField().setBackground(Color.WHITE);
            view.getBudgetTextField().setBackground(Color.WHITE);
        }
    }
}