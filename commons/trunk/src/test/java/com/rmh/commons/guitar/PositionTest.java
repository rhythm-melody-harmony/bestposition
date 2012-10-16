package com.rmh.commons.guitar;

import com.rmh.commons.Note;
import com.rmh.commons.Tone;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zico
 */
public class PositionTest {
    
    private Position position;
    
    @Before
    public void setUp() {
        Tone tone = new Tone(Note.A, 1);
        position = new Position(tone, 2, 6, 2);
    }

    @Test
    public void testPosition() {
        assertEquals(Note.A, position.getTone().getNote());
        assertEquals(2, position.getFret());
        assertEquals(6, position.getString());
        assertEquals(2, position.getFinger());
    }
    
}
