package com.company.Models;

public class Movie {
    private String name, origin;
    private int year;
    private double budget;
    public Movie(String name, int year, String origin, double budget) {
        this.name = name;
        this.year = year;
        this.origin = origin;
        this.budget = budget;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
}