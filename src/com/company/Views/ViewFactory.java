package com.company.Views;

// Abstract factory pattern
public class ViewFactory {
    // Creates an AbstractView
    public static AbstractView createView(ViewTypes viewType) {
        switch (viewType) {
            case ADD:
                return new AddView("Add Movie");
            case LIST:
                return new ListView("All Movies");
            case CHART:
                return new ChartView("Chart");
            default:
                return null;
        }
    }
}
