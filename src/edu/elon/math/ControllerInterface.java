/*
 * ControllerInterface.java 1.0 April 20, 2018
 *
 * Copyright (c) 2018 Casey Hayes, Elon University
 * Elon, North Carolina, 27244 USA
 * All Rights Reserved
 */
package edu.elon.math;

import java.awt.event.ActionEvent;

/**
 * A Controller interface for MVC
 * 
 * @author casey
 *
 */
public interface ControllerInterface {
  void handleButton(ActionEvent e);
  void operate();
}
