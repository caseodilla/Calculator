/*
 * CalcView.java 1.0 April 20, 2018
 *
 * Copyright (c) 2018 Casey Hayes, Elon University
 * Elon, North Carolina, 27244 USA
 * All Rights Reserved
 */
package edu.elon.math;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The View of MVC that displays the calculator GUI.
 * Passes all keystrokes to the Controller for processing.
 * 
 * @author chayes10
 *
 */
@SuppressWarnings("deprecation")
public class CalcView implements Observer {
  private ModelInterface model;
  private ControllerInterface controller;
  
  private JFrame frame;
  private JTextField result;
  private JPanel panel;
  private JButton button;
  
  /**
   * Constructor to create a new GUI
   * 
   * @param controller for the MVC
   * @param model for the MVC
   */
  public CalcView(ControllerInterface controller, ModelInterface model) {
    this.controller = controller;
    this.model = model;
  }
  
  /**
   * Generates the GUI
   */
  public void createView() {
    frame = new JFrame();
    frame.setTitle("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    
    // result field
    result = new JTextField("0");
    frame.add(result, BorderLayout.NORTH);
    
    // button grid
    panel = new JPanel();
    panel.setPreferredSize(new Dimension(200,200));
    panel.setLayout(new GridLayout(4,4));
    
    // string of buttons to feed through a loop to create the GUI
    // in order from Top-Left to Bottom-Right
    String[] buttons = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
    for (String b : buttons) {
      button = new JButton(b);
      button.addActionListener(e -> handleButton(e));
      panel.add(button);
    }
    frame.add(panel, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }
  
  /**
   * Anonymous event listener that passes the event to the controller
   *  
   * @param e the event for the controller to process
   */
  public void handleButton(ActionEvent e) {
    controller.handleButton(e);
  }  
  
  /**
   * Setter method to update the number displayed
   * 
   * @param s text to display
   */
  public void setText(String s) {
    result.setText(s);
  }
  
  /**
   * Getter method to fetch the current string displayed
   * 
   * @return the current displayed text
   */
  public String getText() {
    return result.getText();
  }

  /**
   * Observer's update method to update the View with the result
   */
  @Override
  public void update(Observable o, Object arg) {
    CalcModel model = (CalcModel) o;
    setText("" + model.getResult());
  }

}
