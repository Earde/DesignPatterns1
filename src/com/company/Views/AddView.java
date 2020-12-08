package com.company.Views;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// TextField trigger events (onDataChanged)
@FunctionalInterface
interface SimpleDocumentListener extends DocumentListener {
    void update(DocumentEvent e);

    @Override
    default void insertUpdate(DocumentEvent e) {
        update(e);
    }
    @Override
    default void removeUpdate(DocumentEvent e) {
        update(e);
    }
    @Override
    default void changedUpdate(DocumentEvent e) {
        update(e);
    }
}

public class AddView extends AbstractView {
    private JLabel nameLabel, originLabel, yearLabel, budgetLabel;
    private JTextField nameTextField, originTextField, yearTextField, budgetTextField;
    private JButton saveButton;

    public AddView(String title) {
        super(title);
    }

    // Label Getters
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

    // TextFields Getters
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

    // Textfield AbstractAction Setters
    public void setNameTextFieldAction(AbstractAction action) { nameTextField.getDocument().addDocumentListener((SimpleDocumentListener) e -> action.actionPerformed(null)); }
    public void setOriginTextFieldAction(AbstractAction action) { originTextField.getDocument().addDocumentListener((SimpleDocumentListener) e -> action.actionPerformed(null)); }
    public void setYearTextFieldAction(AbstractAction action) { yearTextField.getDocument().addDocumentListener((SimpleDocumentListener) e -> action.actionPerformed(null)); }
    public void setBudgetTextFieldAction(AbstractAction action) { budgetTextField.getDocument().addDocumentListener((SimpleDocumentListener) e -> action.actionPerformed(null)); }

    // Button Getter
    public JButton getSaveButton() { return saveButton; }

    // Button AbstractAction Setter
    public void setSaveButtonAction(AbstractAction action) {
        String text = saveButton.getText();
        saveButton.setAction(action);
        saveButton.setText(text);
    }

    @Override
    public void CreateLayout() {
        // Set frame properties
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 105);
        setLocationRelativeTo(null);
        setVisible(true);

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
        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        // Horizontal layout
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
        // Vertical layout
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
        // Add layout to Frame
        getContentPane().setLayout(layout);
    }
}