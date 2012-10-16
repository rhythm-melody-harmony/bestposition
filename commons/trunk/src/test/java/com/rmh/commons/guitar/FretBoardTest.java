package com.rmh.commons.guitar;

import com.rmh.commons.Note;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class FretBoardTest {
    
    @Test
    public void testDefaultConstructor() {
        FretBoard fretBoard = new FretBoard();
        
        List<Position> positions = fretBoard.getPositions();
        
        assertEquals(6*22, positions.size());
        
        assertEquals(0, positions.get(0).getFret());
        assertEquals(1, positions.get(0).getString());
        assertEquals(Note.E, positions.get(0).getTone().getNote());
        assertEquals(1, positions.get(0).getTone().getOctave());
        
        assertEquals(21, positions.get(131).getFret());
        assertEquals(6, positions.get(131).getString());
        assertEquals(Note.CSharp, positions.get(131).getTone().getNote());
        assertEquals(1, positions.get(131).getTone().getOctave());
    }
}
