package com.rmh.bestposition.processor.impl;

import com.rmh.bestposition.processor.Processor;
import com.rmh.bestposition.utils.DataBuilder;
import com.rmh.commons.Tone;
import com.rmh.commons.guitar.FretBoard;
import com.rmh.commons.guitar.Position;
import com.rmh.commons.guitar.PositionPoint;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProcessorImplTest {
    
    @Test
    public void testRun() {
        List<PositionPoint> fretBoard = (new FretBoard()).getPositions();
        Processor processor = new ProcessorImpl(fretBoard);
        
        List<Tone> phrase = DataBuilder.buildTestPhrase();
        
        List<List<Position>> bestPositions = processor.run(phrase);
        
        assertNotNull(bestPositions);
    }
    
}