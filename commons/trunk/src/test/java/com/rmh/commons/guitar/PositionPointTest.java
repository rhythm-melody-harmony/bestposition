package com.rmh.commons.guitar;

import com.rmh.commons.Note;
import com.rmh.commons.Tone;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class PositionPointTest {
    
    private PositionPoint position;
    
    @Before
    public void setUp() {
        Tone tone = new Tone(Note.A, 1);
        position = new PositionPoint(tone, 2, 6);
    }

    @Test
    public void testPosition() {
        assertEquals(Note.A, position.getTone().getNote());
        assertEquals(2, position.getFret());
        assertEquals(6, position.getString());
    }
    
}
