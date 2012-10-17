package com.rmh.bestposition.processor.impl;

import com.rmh.bestposition.processor.Processor;
import com.rmh.commons.Note;
import com.rmh.commons.Tone;
import com.rmh.commons.guitar.FretBoard;
import com.rmh.commons.guitar.Position;
import com.rmh.commons.guitar.PositionPoint;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProcessorImplTest {
    
    @Test
    public void testRun() {
        List<PositionPoint> fretBoard = (new FretBoard()).getPositions();
        Processor processor = new ProcessorImpl(fretBoard);
        
        List<Tone> phrase = buildTestPhrase();
        
        List<List<Position>> bestPositions = processor.run(phrase);
        
        assertNotNull(bestPositions);
    }
    
    private List<Tone> buildTestPhrase() {
        List<Tone> phrase = new ArrayList<Tone>();
        
        phrase.add(buildTone(Note.C, 0));
        phrase.add(buildTone(Note.D, 0));
        phrase.add(buildTone(Note.E, 0));
        phrase.add(buildTone(Note.F, 0));
        phrase.add(buildTone(Note.G, 0));
        phrase.add(buildTone(Note.A, 0));
        phrase.add(buildTone(Note.B, 0));
        phrase.add(buildTone(Note.C, 1));
        
        return phrase;
    }
    
    private Tone buildTone(Note note, int octave) {
        Tone tone = new Tone(note, octave);
        return tone;
    }
}
