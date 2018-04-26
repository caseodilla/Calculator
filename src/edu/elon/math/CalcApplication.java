/*
 * CalcApplication.java 1.0 April 20, 2018
 *
 * Copyright (c) 2018 Casey Hayes, Elon University
 * Elon, North Carolina, 27244 USA
 * All Rights Reserved
 */
package edu.elon.math;

/**
 * The driver to initiate the calculator's MVC
 * 
 * @author casey
 *
 */
public class CalcApplication {

  public static void main (String[] args) {
    ModelInterface model = new CalcModel();
    ControllerInterface controller = new CalcController(model);
  }

}
