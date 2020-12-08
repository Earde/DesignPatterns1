package com.company.Views;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

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
    }

    @Override
    public void CreateLayout() {
        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocation(50, 400);
        setVisible(true);

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
        setContentPane(panel);
        panel.revalidate();
        panel.repaint();
    }
}
