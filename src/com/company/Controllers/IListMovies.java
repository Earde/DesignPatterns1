package com.company.Controllers;

import com.company.Models.Movie;
import com.company.Models.ObservableList;
import com.company.Views.ListView;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public interface IListMovies {
    default void updateList(ListView view, ObservableList<Movie> movies) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        movies.getAll().stream().forEach(m -> listModel.addElement(m.getName())); // Stream & lambda
        view.getList().setModel(listModel);
        view.getListPanel().revalidate();
        view.getListPanel().repaint();
    }

    default void deleteItem(ListView view, ObservableList<Movie> movies) {
        int selectedItem = view.getList().getSelectedIndex();
        if (selectedItem >= 0) {
            movies.remove(selectedItem);
        }
    }

    default void infoAboutItem(ListView view, ObservableList<Movie> movies) {
        int selectedItem = view.getList().getSelectedIndex();
        if (selectedItem >= 0) {
            Movie movie = movies.get(selectedItem);
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
