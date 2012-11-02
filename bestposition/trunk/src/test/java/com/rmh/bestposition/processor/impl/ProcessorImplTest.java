package com.rmh.bestposition.processor.impl;

import com.rmh.bestposition.processor.Processor;

import com.rmh.bestposition.utils.DataBuilder;
import com.rmh.commons.Tone;
import com.rmh.commons.guitar.FretBoard;
import com.rmh.commons.guitar.Position;
import com.rmh.commons.guitar.PositionPoint;
import com.rmh.commons.guitar.ToneEdge;
import com.rmh.commons.guitar.ToneVertex;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProcessorImplTest {
    
    @Test
    public void testRun() {
        List<PositionPoint> fretBoard = (new FretBoard()).getPositions();
        List<ToneVertex> nodes = new ArrayList<ToneVertex>();
        List<ToneEdge> edges = new ArrayList<ToneEdge>();
        Processor processor = new ProcessorImpl(fretBoard, nodes, edges);
        
        List<Tone> phrase = DataBuilder.buildTestPhrase();
        
        List<Position> bestPositions = processor.run(phrase);
        
        for (Position position : bestPositions) {
            System.out.println(position.toString());
        }
        assertNotNull(bestPositions);
    }
    
}