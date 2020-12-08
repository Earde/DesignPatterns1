package com.company.Views;

import javax.swing.*;
import java.awt.*;

public class ListView extends AbstractView {
    private JScrollPane scroll;
    private JButton deleteButton, infoButton;
    private JList<String> list;

    private JPanel listPanel, buttonPanel;

    public ListView(String title) {
        super(title);
    }

    @Override
    public void CreateLayout() {
        // Set frame properties
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);
        setLocation(50, 50);
        setVisible(true);

        // Create UI elements
        deleteButton = new JButton("Delete");
        infoButton = new JButton("Info");
        list = new JList<>();
        scroll = new JScrollPane(list);
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
        listPanel.add(scroll);
        listPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(infoButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(deleteButton);

        getContentPane().add(listPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    // Getters
    public JList<String> getList() {
        return list;
    }
    public JButton getDeleteButton() {
        return deleteButton;
    }
    public JButton getInfoButton() {
        return infoButton;
    }
    public JPanel getListPanel() { return listPanel; }

    // AbstractAction Setters
    public void setDeleteButtonAction(AbstractAction action) {
        String text = deleteButton.getText();
        deleteButton.setAction(action);
        deleteButton.setText(text);
    }
    public void setInfoButtonAction(AbstractAction action) {
        String text = infoButton.getText();
        infoButton.setAction(action);
        infoButton.setText(text);
    }
}