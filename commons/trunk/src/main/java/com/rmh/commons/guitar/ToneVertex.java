/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmh.commons.guitar;

/**
 *
 * @author Jovan
 */
public class ToneVertex {
    final private String id;
  final private String name;
  
  
  public ToneVertex(String id, String name) {
    this.id = id;
    this.name = name;
  }
  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(Object obj) {
      ToneVertex other = (ToneVertex) obj;
    if (this.toString().equals(other.toString()) && this.getId().equals(other.getId()))
        return true;
    else
        return false;
  }

  @Override
  public String toString() {
    return name;
  }
}
