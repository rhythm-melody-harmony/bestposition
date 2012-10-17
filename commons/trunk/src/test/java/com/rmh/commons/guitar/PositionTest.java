package com.rmh.commons.guitar;

import com.rmh.commons.Note;
import com.rmh.commons.Tone;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PositionTest {
    
    private Position positionGrip;
    
    @Before
    public void setUp() {
        Tone tone = new Tone(Note.FSharp, -1);
        PositionPoint position = new PositionPoint(tone, 2, 6);
        positionGrip = new Position(position, 1);
    }

    @Test
    public void testPositionGrip() {
        
        assertEquals(Note.FSharp, positionGrip.getPosition().getTone().getNote());
        assertEquals(-1, positionGrip.getPosition().getTone().getOctave());
        assertEquals(2, positionGrip.getPosition().getFret());
        assertEquals(6, positionGrip.getPosition().getString());
        assertEquals(1, positionGrip.getFinger());
    }

}
