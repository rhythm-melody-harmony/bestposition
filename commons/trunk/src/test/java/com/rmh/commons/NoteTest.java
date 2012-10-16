package com.rmh.commons;

import org.junit.Test;
import static org.junit.Assert.*;

public class NoteTest {

    @Test
    public void testValues() {
        System.out.println("values");
        Note[] expResult = buildNoteArray();
        Note[] result = Note.values();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "ASharp";
        Note expResult = Note.ASharp;
        Note result = Note.valueOf(name);
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Note instance = Note.CSharp;
        String expResult = "C#";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    private Note[] buildNoteArray() {
        Note[] notes = {
            Note.A,
            Note.ASharp,
            Note.B,
            Note.C,
            Note.CSharp,
            Note.D,
            Note.DSharp,
            Note.E,
            Note.F,
            Note.FSharp,
            Note.G,
            Note.GSharp
        };
        
        return notes;
    }
}
