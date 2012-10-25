/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmh.commons.guitar;

/**
 *
 * @author Jovan
 */
public class ToneEdge {
  private final String id; 
  private final ToneVertex source;
  private final ToneVertex destination;
  private final int weight; 
  
  public ToneEdge(String id, ToneVertex source, ToneVertex destination, int weight) {
    this.id = id;
    this.source = source;
    this.destination = destination;
    this.weight = weight;
  }
  
  public String getId() {
    return id;
  }
  public ToneVertex getDestination() {
    return destination;
  }

  public ToneVertex getSource() {
    return source;
  }
  public int getWeight() {
    return weight;
  }
  
  @Override
  public String toString() {
    return source + " " + destination;
  }
}
