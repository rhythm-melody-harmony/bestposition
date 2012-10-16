package com.rmh.commons;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ToneTest {
    
    private Tone tone;
    
    @Before
    public void setUp() {
        tone = new Tone(Note.C, 2);
    }
    
    @Test
    public void testTone() {
        assertEquals(Note.C, tone.getNote());
        assertEquals(2, tone.getOctave());
    }
}
