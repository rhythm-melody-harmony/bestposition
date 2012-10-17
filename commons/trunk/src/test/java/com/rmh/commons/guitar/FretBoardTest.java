package com.rmh.commons.guitar;

import com.rmh.commons.Note;
import com.rmh.commons.Tone;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

public class FretBoardTest {
    
    @Test
    public void testDefaultConstructor() {
        FretBoard fretBoard = new FretBoard();
        
        List<PositionPoint> positions = fretBoard.getPositions();
        
        int expectedSize = 6*22;
        assertEquals(expectedSize, positions.size());
        
        assertEquals(0, positions.get(0).getFret());
        assertEquals(1, positions.get(0).getString());
        assertEquals(Note.E, positions.get(0).getTone().getNote());
        assertEquals(1, positions.get(0).getTone().getOctave());
        
        assertEquals(21, positions.get(expectedSize - 1).getFret());
        assertEquals(6, positions.get(expectedSize - 1).getString());
        assertEquals(Note.CSharp, positions.get(expectedSize - 1).getTone().getNote());
        assertEquals(1, positions.get(expectedSize - 1).getTone().getOctave());
    }
    
    @Test
    public void testParameterizedConstructor() {
        Map<String, Object> properties = buildTestProperties();
        
        FretBoard fretBoard = new FretBoard(properties);
        
        List<PositionPoint> positions = fretBoard.getPositions();
        
        int expectedSize = 6*18;
        assertEquals(expectedSize, positions.size());
        
        assertEquals(0, positions.get(0).getFret());
        assertEquals(1, positions.get(0).getString());
        assertEquals(Note.E, positions.get(0).getTone().getNote());
        assertEquals(1, positions.get(0).getTone().getOctave());
        
        assertEquals(17, positions.get(expectedSize - 1).getFret());
        assertEquals(6, positions.get(expectedSize - 1).getString());
        assertEquals(Note.G, positions.get(expectedSize - 1).getTone().getNote());
        assertEquals(0, positions.get(expectedSize - 1).getTone().getOctave());
    }
    
    private Map<String, Object> buildTestProperties() {
        Map<String, Object> properties = new HashMap<String, Object>();
        
        properties.put("numberOfFrets", new Integer(17));
        properties.put("numberOfStrings", new Integer(6));
        
        Tone[] tuningDropD = new Tone[6];
        
        tuningDropD[0] = laodTone(Note.E, 1);
        tuningDropD[1] = laodTone(Note.B, 0);
        tuningDropD[2] = laodTone(Note.G, 0);
        tuningDropD[3] = laodTone(Note.D, 0);
        tuningDropD[4] = laodTone(Note.A, -1);
        tuningDropD[5] = laodTone(Note.D, -1);
        
        properties.put("tuning", tuningDropD);
        
        return properties;
    }
    
    private Tone laodTone(Note note, int octave) {
        Tone tone = new Tone(note, octave);
        return tone;
    }
}
