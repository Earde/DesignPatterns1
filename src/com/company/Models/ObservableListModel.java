package com.company.Models;

import java.util.ArrayList;
import java.util.Observable;

// Model - Generic observable list
public class ObservableListModel<T> extends Observable {
    private ArrayList<T> list;

    public ObservableListModel() {
        list = new ArrayList<>();
    }

    // Add item and notify observers
    public void add(T item) {
        list.add(item);
        setChanged();
        notifyObservers();
    }

    // Return complete list
    public ArrayList<T> getAll() {
        return list;
    }

    // Get item at index i
    public T get(int i) {
        return list.get(i);
    }

    // Remove item at index i and notify observers
    public void remove(int i) {
        list.remove(i);
        setChanged();
        notifyObservers();
    }
}