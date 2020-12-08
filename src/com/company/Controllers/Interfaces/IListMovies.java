package com.company.Controllers.Interfaces;

import com.company.Models.MovieEntity;
import com.company.Models.ObservableListModel;
import com.company.Views.ListView;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public interface IListMovies {
    // 1. Clear list
    // 2. Add all movies
    default void updateList(ListView view, ObservableListModel<MovieEntity> movies) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        movies.getAll().stream().forEach(m -> listModel.addElement(m.getName())); // Stream & lambda
        view.getList().setModel(listModel);
        view.getListPanel().revalidate();
        view.getListPanel().repaint();
    }

    // Delete movie from list
    default void deleteItem(ListView view, ObservableListModel<MovieEntity> movies) {
        int selectedItem = view.getList().getSelectedIndex();
        if (selectedItem >= 0) {
            movies.remove(selectedItem);
        }
    }

    // Display info about movie
    default void infoAboutItem(ListView view, ObservableListModel<MovieEntity> movies) {
        int selectedItem = view.getList().getSelectedIndex();
        if (selectedItem >= 0) {
            MovieEntity movie = movies.get(selectedItem);
            showMessageDialog(null,
                    "Name: " + movie.getName() +
                    "\nOrigin: " + movie.getOrigin() +
                    "\nYear: " + movie.getYear() +
                    "\nBudget: " + movie.getBudget(),
                    "Info about " + movie.getName(),
                    INFORMATION_MESSAGE);
        }
    }
}
