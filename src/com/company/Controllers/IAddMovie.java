package com.company.Controllers;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public interface IAddMovie {
    void initAddMovie();

    default void setIsValidInputListener(ICustomFunction function, JTextField textField) {
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                changedUpdate(documentEvent);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                changedUpdate(documentEvent);
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                function.execute(textField);
            }
        };
        textField.getDocument().addDocumentListener(documentListener);
    }

    //changes background color of textfield and disables/enables savebutton
    default void handleTextField(JTextField textField, JButton saveButton, boolean isValid) {
        if (isValid) {
            textField.setBackground(Color.WHITE);
        } else {
            textField.setBackground(Color.RED);
        }
        saveButton.setEnabled(isSavable());
    }

    default boolean isTextValid(JTextField textField) {
        String text = textField.getText();
        return !text.isEmpty();
    }

    default boolean isYearValid(JTextField textField) {
        try {
            Integer.parseInt(textField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    default boolean isBudgetValid(JTextField textField) {
        try {
            Double.parseDouble(textField.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //check if all mandatory fields are filled in to add a new movie
    boolean isSavable();

    //save movie
    void saveMovie();
}
