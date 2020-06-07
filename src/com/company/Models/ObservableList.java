package com.company.Models;

import java.util.ArrayList;
import java.util.Observable;

// Generic observable list
public class ObservableList<T> extends Observable {
    private ArrayList<T> list;

    public ObservableList() {
        list = new ArrayList<>();
    }

    public void add(T item) {
        list.add(item);
        setChanged();
        notifyObservers();
    }

    public ArrayList<T> getAll() {
        return list;
    }

    public T get(int i) {
        return list.get(i);
    }

    public void remove(int i) {
        list.remove(i);
        setChanged();
        notifyObservers();
    }
}