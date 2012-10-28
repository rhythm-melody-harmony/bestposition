/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rmh.commons;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.Math;

import org.junit.Test;

import com.rmh.commons.guitar.ToneVertex;
import com.rmh.commons.guitar.ToneEdge;
import com.rmh.commons.guitar.PhraseGraph;
import com.rmh.commons.guitar.DijkstraAlgorithm;

import com.rmh.commons.Tone;
import com.rmh.commons.guitar.FretBoard;
import com.rmh.commons.guitar.Position;
import com.rmh.commons.guitar.PositionPoint;
import com.rmh.bestposition.utils.DataBuilder;
import com.rmh.bestposition.processor.impl.PhrasePositionsFinder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 *
 * @author Jovan
 */
public class TestDijkstraAlgorithm {
    private List<ToneVertex> nodes;
  private List<ToneEdge> edges;

  @Test
  public void testExcute() {
    nodes = new ArrayList<ToneVertex>();
    edges = new ArrayList<ToneEdge>();
    for (int i = 0; i < 11; i++) {
      ToneVertex location = new ToneVertex("Node_" + i, "Node_" + i);
      nodes.add(location);
    }

      addLane("Edge_0", 0, 1, 85);
    addLane("Edge_1", 0, 2, 217);
    addLane("Edge_2", 0, 4, 173);
    addLane("Edge_3", 2, 6, 186);
    addLane("Edge_4", 2, 7, 103);
    addLane("Edge_5", 3, 7, 183);
    addLane("Edge_6", 5, 8, 250);
    addLane("Edge_7", 8, 9, 84);
    addLane("Edge_8", 7, 9, 167);
    addLane("Edge_9", 4, 9, 502);
    addLane("Edge_10", 9, 10, 40);
    addLane("Edge_11", 1, 10, 600);

    // Lets check from location Loc_1 to Loc_10
    PhraseGraph graph = new PhraseGraph(nodes, edges);
    DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
    dijkstra.execute(nodes.get(0));
    LinkedList<ToneVertex> path = dijkstra.getPath(nodes.get(10));
    
    assertNotNull(path);
    assertTrue(path.size() > 0);
    
    
    
  }
  @Test
  public void testFindBestPosition(){
      nodes = new ArrayList<ToneVertex>();
      edges = new ArrayList<ToneEdge>();
      List<Tone> phrase = DataBuilder.buildTestPhrase();
      List<PositionPoint> fretBoard = (new FretBoard()).getPositions();
        boolean useThumbFinger = false;
        boolean useOpenStrings = false;
        PhrasePositionsFinder phrasePositionsFinder = new PhrasePositionsFinder(fretBoard, useThumbFinger, useOpenStrings);
        //List<Position> positions = phrasePositionsFinder.findPositions(phrase);
        String PositionLevel [][]=new String[phrase.size()][];
        int Fret[][]=new int[phrase.size()][];
        int String[][]=new int[phrase.size()][];
        int Finger[][]=new int[phrase.size()][];
        for(int i=0;i<phrase.size();i++){
            List<Position> TonePositions = phrasePositionsFinder.findTonePositions(phrase.get(i));
            PositionLevel[i]=new String[TonePositions.size()];
            Fret[i]=new int[TonePositions.size()];
            String[i]=new int[TonePositions.size()];
            Finger[i]=new int[TonePositions.size()];
         
            for(int j=0;j<TonePositions.size();j++){
                PositionLevel[i][j]= TonePositions.get(j).toString();
                Fret[i][j]= TonePositions.get(j).getPosition().getFret();
                String[i][j]= TonePositions.get(j).getPosition().getString();
                Finger[i][j]= TonePositions.get(j).getFinger();
            }
        }
        ToneVertex nodeBegin = new ToneVertex("Node_begin","Node_begin");
        nodes.add(nodeBegin);
        for(int i=0;i<PositionLevel.length;i++){
            for(int j=0;j<PositionLevel[i].length;j++){
            ToneVertex node = new ToneVertex("Node"+i+"-"+j,PositionLevel[i][j]);
            nodes.add(node);
        }
        }
        ToneVertex nodeEnd = new ToneVertex("Node_end","Node_end");
        nodes.add(nodeEnd);
      for(int m=0;m<PositionLevel[0].length;m++)
          addLane("Edge_0"+m,0,nodes.indexOf(new ToneVertex("Node0-"+m,PositionLevel[0][m])),0);
      for(int i=0;i<PositionLevel.length;i++){
            for(int j=0;j<PositionLevel[i].length;j++){
               for(int k=0;k<PositionLevel[i].length;k++){
                   if(i!=PositionLevel.length-1){
                        int s=i+1;
                        addLane("Edge_"+i+"_"+j+"_"+k, nodes.indexOf(new ToneVertex("Node"+i+"-"+j,PositionLevel[i][j])), nodes.indexOf(new ToneVertex("Node"+s+"-"+k, PositionLevel[s][k])), calculateWeight(Fret[i][j],Fret[s][k],String[i][j],String[s][k],Finger[i][j],Finger[s][k]));  
                   }
               }
            }
      }
      for(int m=0;m<PositionLevel[PositionLevel.length-1].length;m++)
          addLane("Edge_"+(PositionLevel.length-1)+"_"+m, nodes.indexOf(new ToneVertex("Node"+(PositionLevel.length-1)+"-"+m,PositionLevel[PositionLevel.length-1][m])),nodes.size()-1,0);
      PhraseGraph graph = new PhraseGraph(nodes, edges);
      DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
      dijkstra.execute(nodes.get(0));
      LinkedList<ToneVertex> path = dijkstra.getPath(nodes.get(nodes.size()-1));
      
       for(ToneEdge edge:edges)
       {
           System.out.println(edge.toString());
       }
                   for(ToneVertex vertex:path){
                        System.out.println(vertex.toString());
                    }
                    
       
        assertNotNull(PositionLevel);
  }
  private void addLane(String laneId, int sourceLocNo, int destLocNo,
      int duration) {
    ToneEdge lane = new ToneEdge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
    edges.add(lane);
  }
  public int calculateWeight(int FretOne,int FretTwo,int StringOne,int StringTwo, int FingerOne, int FingerTwo){
       return (Math.abs(FretTwo-FretOne)+Math.abs(StringTwo-StringOne)+Math.abs((FretTwo-FretOne)-((FingerTwo-FingerOne))));
    }
} 