package com.company.Controllers;

import com.company.Models.Movie;
import com.company.Views.AddView;
import javafx.collections.ObservableList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public interface IAddMovie {
    default void initAddMovie(AddView view, ObservableList<Movie> movies) {
        // Bind CustomFunction (lambda) to onTextChanged callback of TextFields
        setIsValidInputListener((tf) -> handleTextField(tf, view, isTextValid(tf)), view.getOriginTextField());
        setIsValidInputListener((tf) -> handleTextField(tf, view, isYearValid(tf)), view.getYearTextField());
        setIsValidInputListener((tf) -> handleTextField(tf, view, isBudgetValid(tf)), view.getBudgetTextField());
        setIsValidInputListener((tf) -> handleTextField(tf, view, isTextValid(tf)), view.getNameTextField());
        // Bind saveMovie function to saveButton onClick callback
        view.getSaveButton().addActionListener(e -> saveMovie(view, movies));
        view.getSaveButton().setEnabled(isSavable(view));
    }

    default void setIsValidInputListener(ICustomFunction function, JTextField textField) {
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                changedUpdate(documentEvent);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) { changedUpdate(documentEvent); }

            // Execute custom function on textField change
            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                function.execute(textField);
            }
        };
        textField.getDocument().addDocumentListener(documentListener);
    }

    // Changes background color of textfield and disables/enables savebutton
    default void handleTextField(JTextField textField, AddView view, boolean isValid) {
        if (isValid) {
            textField.setBackground(Color.WHITE);
        } else {
            textField.setBackground(Color.RED);
        }
        view.getSaveButton().setEnabled(isSavable(view));
    }

    // TextField valid input functions
    default boolean isTextValid(JTextField textField) {
        String text = textField.getText();
        return !text.isEmpty();
    }
    default boolean isYearValid(JTextField textField) {
        try {
            Integer.parseInt(textField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    default boolean isBudgetValid(JTextField textField) {
        try {
            Double.parseDouble(textField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Check if all mandatory TextFields are valid
    default boolean isSavable(AddView view) {
        return  isBudgetValid(view.getBudgetTextField()) &&
                isTextValid(view.getNameTextField()) &&
                isTextValid(view.getOriginTextField()) &&
                isYearValid(view.getYearTextField());
    }

    // Save movie and reset TextFields layout
    default void saveMovie(AddView view, ObservableList<Movie> movies) {
        if (isSavable(view)) {
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
