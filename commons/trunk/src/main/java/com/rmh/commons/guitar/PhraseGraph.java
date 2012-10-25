/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmh.commons.guitar;

import java.util.List;

/**
 *
 * @author Jovan
 */
public class PhraseGraph {
  private final List<ToneVertex> vertexes;
  private final List<ToneEdge> edges;

  public PhraseGraph(List<ToneVertex> vertexes, List<ToneEdge> edges) {
    this.vertexes = vertexes;
    this.edges = edges;
  }

  public List<ToneVertex> getVertexes() {
    return vertexes;
  }

  public List<ToneEdge> getEdges() {
    return edges;
  }
}
