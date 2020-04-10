package com.company.Views;

import com.company.Controllers.Controller;

import javax.swing.*;

public abstract class AbstractView {
    private JFrame frame;

    // Init JFrame
    public AbstractView(String title) {
        this.frame = new JFrame(title);
    }
    // Create UI elements
    public abstract void init();
    // Get JFrame
    public JFrame getFrame() {
        return frame;
    }
}
