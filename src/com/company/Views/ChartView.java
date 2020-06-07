package com.company.Views;

import javafx.scene.chart.NumberAxis;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;

import javax.swing.*;

public class ChartView extends AbstractView {
    private ChartPanel panel;
    private JFreeChart chart;

    public ChartPanel getPanel() {
        return panel;
    }

    public JFreeChart getChart() {
        return chart;
    }

    public ChartView(String title) {
        super(title);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setSize(600, 400);
        getFrame().setLocation(50, 400);
        getFrame().setVisible(true);

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.setValue(1, " ", " ");

        chart = ChartFactory.createBarChart(
                "Movies from",
                "Origin",
                "Count",
                new DefaultCategoryDataset(),
                PlotOrientation.VERTICAL,
                false,
                true,
                false);
        panel = new ChartPanel(chart);
        getFrame().setContentPane(panel);
        panel.revalidate();
        panel.repaint();
    }
}
