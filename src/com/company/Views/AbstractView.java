package com.company.Views;

import javax.swing.*;

public abstract class AbstractView {
    private JFrame frame;
    // Init JFrame
    public AbstractView(String title) { this.frame = new JFrame(title); }
    // Get JFrame
    public JFrame getFrame() {
        return frame;
    }
}
