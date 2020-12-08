package com.company.Views;

// Abstract View
public abstract class AbstractView extends javax.swing.JFrame {
    public AbstractView(String title) {
        this.setTitle(title);
        this.CreateLayout();
    }
    public abstract void CreateLayout();
}
