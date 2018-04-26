/*
 * CalcController.java 1.0 April 20, 2018
 *
 * Copyright (c) 2018 Casey Hayes, Elon University
 * Elon, North Carolina, 27244 USA
 * All Rights Reserved
 */
package edu.elon.math;

import java.awt.event.ActionEvent;

/**
 * Controller of MVC to handle the operations of the GUI and
 * instruct the Model what to perform.
 * 
 * @author chayes10
 *
 */
public class CalcController implements ControllerInterface {
  ModelInterface model;
  CalcView view;
  
  private Double left;
  private Double right;
  private String op;
  private boolean newNumber = true;
  private boolean hasDecimal = false;

  /**
   * Constructor that creates a new Controller for MVC
   * 
   * @param model
   */
  @SuppressWarnings("deprecation")
  public CalcController(ModelInterface model) {
    this.model = model;
    view = new CalcView(this, model);
    view.createView();
    ((CalcModel) model).addObserver(view);
  }
  
  /**
   * Anonymous action listener to handle any button pressed from the GUI
   * 
   * @param e the action event
   */
  public void handleButton(ActionEvent e) {
    String s = e.getActionCommand();
    try {
      Integer.parseInt(s);
      if (newNumber) {
        view.setText(s);
        newNumber = false;
      } else {
        view.setText(view.getText() + s);
      }
    } catch (NumberFormatException | NullPointerException er) {
      if (s.equals(".")) {
        if (!hasDecimal) {
          if (newNumber) {
            view.setText("0");
            newNumber = false;
          }
          view.setText(view.getText() + ".");
          hasDecimal = true;
        }
      } else {
        if (left == null) {
          left = Double.parseDouble(view.getText());
        }
        if (op != null) {
          right = Double.parseDouble(view.getText());
          operate();
        }
        op = s;
        hasDecimal = false;
        newNumber = true;
      }
    }
  }

  /**
   * Pass the values and operator to the model for operation
   */
  @Override
  public void operate() {
    left = model.operate(left, op, right);
  }

}
