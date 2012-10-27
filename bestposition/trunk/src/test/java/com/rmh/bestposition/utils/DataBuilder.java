package com.rmh.bestposition.utils;

import com.rmh.commons.Note;
import com.rmh.commons.Tone;
import java.util.ArrayList;
import java.util.List;

public class DataBuilder {
    
    public static List<Tone> buildTestPhrase() {
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
    
    public static List<Tone> buildOpenStringsTestPhrase() {
        List<Tone> phrase = new ArrayList<Tone>();
        
        phrase.add(buildTone(Note.E, 1));
        phrase.add(buildTone(Note.B, 0));
        phrase.add(buildTone(Note.G, 0));
        phrase.add(buildTone(Note.D, 0));
        phrase.add(buildTone(Note.A, -1));
        phrase.add(buildTone(Note.E, -1));
        
        return phrase;
    }
    
    public static List<Tone> buildThumbTestPhrase() {
        List<Tone> phrase = new ArrayList<Tone>();
        
        phrase.add(buildTone(Note.C, 0));
        phrase.add(buildTone(Note.D, 0));
        
        return phrase;
    }
    
    private static Tone buildTone(Note note, int octave) {
        Tone tone = new Tone(note, octave);
        return tone;
    }
}
