package com.rmh.bestposition.processor.impl;
import com.rmh.bestposition.processor.Processor;
import com.rmh.commons.Tone;
import com.rmh.commons.guitar.DijkstraAlgorithm;
import com.rmh.commons.guitar.PhraseGraph;
import com.rmh.commons.guitar.Position;
import com.rmh.commons.guitar.PositionPoint;
import com.rmh.commons.guitar.ToneEdge;
import com.rmh.commons.guitar.ToneVertex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProcessorImpl implements Processor {
    
    private List<PositionPoint> fretBoard;
    private List<ToneVertex> nodes;
    private List<ToneEdge> edges;
    
    public ProcessorImpl(List<PositionPoint> fretBoard,List<ToneVertex> nodes, List<ToneEdge> edges) {
        this.fretBoard = fretBoard;
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<Position> run(List<Tone> phrase) {
//        List<List<Position>> positionsList = new ArrayList<List<Position>>();
//        return positionsList;
        Map map = new HashMap();
        boolean useThumbFinger = false;
        boolean useOpenStrings = false;
        PhrasePositionsFinder phrasePositionsFinder = new PhrasePositionsFinder(fretBoard, useThumbFinger, useOpenStrings);
        //List<Position> positions = phrasePositionsFinder.findPositions(phrase);
        String PositionLevel[][] = new String[phrase.size()][];
        int Fret[][] = new int[phrase.size()][];
        int String[][] = new int[phrase.size()][];
        int Finger[][] = new int[phrase.size()][];
        for (int i = 0; i < phrase.size(); i++) {
            List<Position> TonePositions = phrasePositionsFinder.findTonePositions(phrase.get(i));
            PositionLevel[i] = new String[TonePositions.size()];
            Fret[i] = new int[TonePositions.size()];
            String[i] = new int[TonePositions.size()];
            Finger[i] = new int[TonePositions.size()];

            for (int j = 0; j < TonePositions.size(); j++) {
                PositionLevel[i][j] = TonePositions.get(j).toString();
                Fret[i][j] = TonePositions.get(j).getPosition().getFret();
                String[i][j] = TonePositions.get(j).getPosition().getString();
                Finger[i][j] = TonePositions.get(j).getFinger();
                map.put(PositionLevel[i][j], TonePositions.get(j));
            }
        }
        ToneVertex nodeBegin = new ToneVertex("Node_begin", "Node_begin");
        nodes.add(nodeBegin);
        for (int i = 0; i < PositionLevel.length; i++) {
            for (int j = 0; j < PositionLevel[i].length; j++) {
                ToneVertex node = new ToneVertex("Node" + i + "-" + j, PositionLevel[i][j]);
                nodes.add(node);
            }
        }
        ToneVertex nodeEnd = new ToneVertex("Node_end", "Node_end");
        nodes.add(nodeEnd);
        for (int m = 0; m < PositionLevel[0].length; m++) {
            addLane("Edge_0" + m, 0, nodes.indexOf(new ToneVertex("Node0-" + m, PositionLevel[0][m])), 0);
        }
        for (int i = 0; i < PositionLevel.length; i++) {
            for (int j = 0; j < PositionLevel[i].length; j++) {
                if ((i + 1) < PositionLevel.length) {
                    for (int k = 0; k < PositionLevel[i + 1].length; k++) {
                        if (i != PositionLevel.length - 1) {
                            int s = i + 1;
                            addLane("Edge_" + i + "_" + j + "_" + k, nodes.indexOf(new ToneVertex("Node" + i + "-" + j, PositionLevel[i][j])), nodes.indexOf(new ToneVertex("Node" + s + "-" + k, PositionLevel[s][k])), calculateWeight(Fret[i][j], Fret[s][k], String[i][j], String[s][k], Finger[i][j], Finger[s][k]));
                        }
                    }
                }
            }
        }
        for (int m = 0; m < PositionLevel[PositionLevel.length - 1].length; m++) {
            addLane("Edge_" + (PositionLevel.length - 1) + "_" + m, nodes.indexOf(new ToneVertex("Node" + (PositionLevel.length - 1) + "-" + m, PositionLevel[PositionLevel.length - 1][m])), nodes.size() - 1, 0);
        }
        PhraseGraph graph = new PhraseGraph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<ToneVertex> path = dijkstra.getPath(nodes.get(nodes.size() - 1));
        path.removeLast();
        path.removeFirst();
        List<Position> PositionList = new ArrayList<Position>();
        
        for (ToneVertex vertex : path) { 
            PositionList.add((Position)map.get(vertex.getName()));
        }
        return PositionList;
    }
    

    private void addLane(String laneId, int sourceLocNo, int destLocNo,int duration) {
        ToneEdge lane = new ToneEdge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }

    public int calculateWeight(int FretOne, int FretTwo, int StringOne, int StringTwo, int FingerOne, int FingerTwo) {
        return (Math.abs(FretTwo - FretOne) + Math.abs(StringTwo - StringOne) + Math.abs((FretTwo - FretOne) - ((FingerTwo - FingerOne))));
    }
}
