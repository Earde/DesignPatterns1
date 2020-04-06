package com.company.Views;

import java.awt.BorderLayout;
import javax.swing.*;

public class View {
    private JFrame frame;
    private JLabel nameLabel, originLabel, yearLabel, budgetLabel;
    private JTextField nameTextField, originTextField, yearTextField, budgetTextField;
    private JButton saveButton;

    public View(String title) {
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 120);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // Create UI elements
        nameLabel = new JLabel("Name :");
        originLabel = new JLabel("Origin :");
        yearLabel = new JLabel("Year :");
        budgetLabel = new JLabel("Budget :");
        nameTextField = new JTextField();
        originTextField = new JTextField();
        yearTextField = new JTextField();
        budgetTextField = new JTextField();
        saveButton = new JButton("Save");
        // Add UI elements to frame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        //horizontal layout
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(nameLabel)
                        .addComponent(nameTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(originLabel)
                        .addComponent(originTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(yearLabel)
                        .addComponent(yearTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(budgetLabel)
                        .addComponent(budgetTextField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(saveButton)));
        //vertical layout
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(nameLabel)
                    .addComponent(originLabel)
                    .addComponent(yearLabel)
                    .addComponent(budgetLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(nameTextField)
                        .addComponent(originTextField)
                        .addComponent(yearTextField)
                        .addComponent(budgetTextField)
                        .addComponent(saveButton)));
        frame.getContentPane().setLayout(layout);
    }
    //Frame
    public JFrame getFrame() {
        return frame;
    }
    //Labels
    public JLabel getNameLabel() {
        return nameLabel;
    }
    public JLabel getOriginLabel() {
        return originLabel;
    }
    public JLabel getYearLabel() {
        return yearLabel;
    }
    public JLabel getBudgetLabel() {
        return budgetLabel;
    }
    //TextFields
    public JTextField getNameTextField() {
        return nameTextField;
    }
    public JTextField getOriginTextField() {
        return originTextField;
    }
    public JTextField getYearTextField() {
        return yearTextField;
    }
    public JTextField getBudgetTextField() {
        return budgetTextField;
    }
    //Buttons
    public JButton getSaveButton() {
        return saveButton;
    }
}