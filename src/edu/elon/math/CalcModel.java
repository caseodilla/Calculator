/*
 * CalcModel.java 1.0 April 20, 2018
 *
 * Copyright (c) 2018 Casey Hayes, Elon University
 * Elon, North Carolina, 27244 USA
 * All Rights Reserved
 */
package edu.elon.math;

import java.util.Observable;

/**
 * The Model of MVC that handles the operations of a calculator.
 * 
 * @author chayes10
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class CalcModel extends Observable implements ModelInterface {
  private Double result;
  
  /**
   * Performs a calculation based on the operator.
   * 
   * @param left the number to the left of the operator
   * @param op the operation to perform
   * @param right the number to the right of the operator
   * 
   * @return <code>Double</code> result of the operation
   */
  @Override
  public Double operate(Double left, String op, Double right) {
    System.out.print(left + " " + op + " " + right);
    switch (op) {
    case "+":
      result = left + right;
      break;
    case "-":
      result = left - right;
      break;
    case "*":
      result = left * right;
      break;
    case "/":
      result = left / right;
      break;
    case "=":
      result = right;
      break;
    }
    System.out.print(" = " + result + "\n");
    setChanged();
    notifyObservers();
    return result;
  }
  
  /**
   * Getter method to fetch the private result
   * 
   * @return Double result of the operation
   */
  @Override
  public Double getResult() {
    return result;
  }

}
