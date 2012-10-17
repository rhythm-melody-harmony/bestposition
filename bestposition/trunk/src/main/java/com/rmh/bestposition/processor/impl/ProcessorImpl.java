package com.rmh.bestposition.processor.impl;

import com.rmh.bestposition.processor.Processor;
import com.rmh.commons.Tone;
import com.rmh.commons.guitar.Position;
import com.rmh.commons.guitar.PositionPoint;
import java.util.ArrayList;
import java.util.List;

public class ProcessorImpl implements Processor {
    
    private List<PositionPoint> fretBoard;
    
    public ProcessorImpl(List<PositionPoint> fretBoard) {
        this.fretBoard = fretBoard;
    }

    @Override
    public List<List<Position>> run(List<Tone> phrase) {
        List<List<Position>> positionsList = new ArrayList<List<Position>>();
        
        return positionsList;
    }
    
}
