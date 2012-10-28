/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmh.commons.guitar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.rmh.commons.guitar.ToneVertex;
import com.rmh.commons.guitar.ToneEdge;
import com.rmh.commons.guitar.PhraseGraph;
  
/**
 *
 * @author Jovan
 */
public class DijkstraAlgorithm {
  private final List<ToneVertex> nodes;
  private final List<ToneEdge> edges;
  private Set<ToneVertex> settledNodes;
  private Set<ToneVertex> unSettledNodes;
  private Map<ToneVertex, ToneVertex> predecessors;
  private Map<ToneVertex, Integer> distance;

  public DijkstraAlgorithm(PhraseGraph graph) {
    // Create a copy of the array so that we can operate on this array
    this.nodes = new ArrayList<ToneVertex>(graph.getVertexes());
    this.edges = new ArrayList<ToneEdge>(graph.getEdges());
  }

  public void execute(ToneVertex source) {
    settledNodes = new HashSet<ToneVertex>();
    unSettledNodes = new HashSet<ToneVertex>();
    distance = new HashMap<ToneVertex, Integer>();
    predecessors = new HashMap<ToneVertex, ToneVertex>();
    distance.put(source, 0);
    unSettledNodes.add(source);
    while (unSettledNodes.size() > 0) {
      ToneVertex node = getMinimum(unSettledNodes);
      settledNodes.add(node);
      unSettledNodes.remove(node);
      findMinimalDistances(node);
    }
  }

  private void findMinimalDistances(ToneVertex node) {
    List<ToneVertex> adjacentNodes = getNeighbors(node);
    for (ToneVertex target : adjacentNodes) {
      if (getShortestDistance(target) > getShortestDistance(node)
          + getDistance(node, target)) {
        distance.put(target, getShortestDistance(node)
            + getDistance(node, target));
        predecessors.put(target, node);
        unSettledNodes.add(target);
      }
    }

  }

  private int getDistance(ToneVertex node, ToneVertex target) {
    for (ToneEdge edge : edges) {
      if (edge.getSource().equals(node)
          && edge.getDestination().equals(target)) {
        return edge.getWeight();
      }
    }
    throw new RuntimeException("Should not happen");
  }

  private List<ToneVertex> getNeighbors(ToneVertex node) {
    List<ToneVertex> neighbors = new ArrayList<ToneVertex>();
    for (ToneEdge edge : edges) {
      if (edge.getSource().equals(node)
          && !isSettled(edge.getDestination())) {
        neighbors.add(edge.getDestination());
      }
    }
    return neighbors;
  }

  private ToneVertex getMinimum(Set<ToneVertex> vertexes) {
    ToneVertex minimum = null;
    for (ToneVertex vertex : vertexes) {
      if (minimum == null) {
        minimum = vertex;
      } else {
        if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
          minimum = vertex;
        }
      }
    }
    return minimum;
  }

  private boolean isSettled(ToneVertex vertex) {
    return settledNodes.contains(vertex);
  }

  private int getShortestDistance(ToneVertex destination) {
    Integer d = distance.get(destination);
    if (d == null) {
      return Integer.MAX_VALUE;
    } else {
      return d;
    }
  }

  /*
   * This method returns the path from the source to the selected target and
   * NULL if no path exists
   */
  public LinkedList<ToneVertex> getPath(ToneVertex target) {
    LinkedList<ToneVertex> path = new LinkedList<ToneVertex>();
    ToneVertex step = target;
    // Check if a path exists
    if (predecessors.get(step) == null) {
      return null;
    }
    path.add(step);
    while (predecessors.get(step) != null) {
      step = predecessors.get(step);
      path.add(step);
    }
    // Put it into the correct order
    Collections.reverse(path);
    return path;
  }
}
