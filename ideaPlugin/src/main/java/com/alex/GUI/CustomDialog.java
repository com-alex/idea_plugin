package com.alex.GUI;

import javax.swing.*;
import java.awt.event.*;

public class CustomDialog extends JDialog {
    private JPanel contentPane;
    private JPanel panel1;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JRadioButton trelloButton;
    private JRadioButton mondayButton;
    private JRadioButton fromLabsButton;



    public CustomDialog() {

        panel1.setBounds(0,0, 100, 100);
        panel1.setLayout(null);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Username:");
        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password:");
        nameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        nameLabel.setBounds(100,20,100,30);
        passwordLabel.setBounds(100, 50, 100,30);
        nameField.setBounds(200, 20,100,30);
        passwordField.setBounds(200, 50, 100, 30);

        ButtonGroup buttonGroup = new ButtonGroup();
        trelloButton = new JRadioButton("trello", true);
        mondayButton = new JRadioButton("monday", false);
        fromLabsButton = new JRadioButton("FromLabs PMS", false);

        trelloButton.setBounds(20, 100, 100,50);
        mondayButton.setBounds(120,100, 100, 50);
        fromLabsButton.setBounds(230, 100, 200, 50);
        buttonGroup.add(trelloButton);
        buttonGroup.add(mondayButton);
        buttonGroup.add(fromLabsButton);

        panel1.add(passwordLabel);
        panel1.add(nameLabel);
        panel1.add(nameField);
        panel1.add(passwordField);
        panel1.add(trelloButton);
        panel1.add(mondayButton);
        panel1.add(fromLabsButton);


        setContentPane(contentPane);
        setModal(true);


    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }




}
