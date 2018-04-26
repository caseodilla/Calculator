/*
 * ModelInterface.java 1.0 April 20, 2018
 *
 * Copyright (c) 2018 Casey Hayes, Elon University
 * Elon, North Carolina, 27244 USA
 * All Rights Reserved
 */
package edu.elon.math;

/**
 * A Model interface for the MVC
 * 
 * @author chayes10
 *
 */
public interface ModelInterface {
  public Double operate(Double left, String op, Double right);
  
  public Double getResult();
}
