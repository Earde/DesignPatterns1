package com.company.Views;

// Abstract factory pattern
// Create AbstractViews
public class ViewFactory {
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
