package com.rmh.commons.guitar;

import com.rmh.commons.Note;
import com.rmh.commons.Tone;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FretBoard {
    
    private int numberOfFrets;
    private int numberOfStrings;
    private Tone[] tuning;
    
    public FretBoard(Map<String, Object> properties) {
        this();
        extractProperties(properties);
    }
    
    public FretBoard() {
        loadDefaultProperties();
    }
    
    public List<Position> getPositions() {
        List<Position> positions = new ArrayList<Position>();
        
        for (int i = 0; i < numberOfStrings; i++) {
            createString(i, positions);
        }
        
        return positions;
    }
    
    private void createString(int string, List<Position> positions) {
        for (int i = 0; i < numberOfFrets+1; i++) {
            Tone tone = createTone(string, i);
            Position position = new Position(tone, i, string+1);
            
            positions.add(position);
        }
    }
    
    private Tone createTone(int string, int fret) {
        Tone tuningTone = tuning[string];
        Note openStringNote = tuningTone.getNote();
        int openStringOctave = tuningTone.getOctave();
        
        int noteIncrement = fret % 12;
        int octaveIncrement = (fret - noteIncrement) / 12;
        int octave = openStringOctave + octaveIncrement;
        
        int noteIndex = openStringNote.ordinal() + noteIncrement;
        if (noteIndex > 11) {
            noteIndex = noteIndex - 12;
        }
        Note note = Note.values()[noteIndex];
        
        Tone tone = new Tone(note, octave);
        
        return tone;
    }
    
    private void extractProperties(Map<String, Object> properties) {
        String key = "numberOfFrets";
        if (properties.containsKey(key)) {
            numberOfFrets = (Integer)properties.get(key);
        }
        
        key = "numberOfStrings";
        if (properties.containsKey(key)) {
            numberOfFrets = (Integer)properties.get(key);
        }
        
        key = "tuning";
        if (properties.containsKey(key)) {
            tuning = (Tone[])properties.get(key);
        }
    }

    private void loadDefaultProperties() {
        numberOfFrets = 21;
        numberOfStrings = 6;
        tuning = new Tone[6];
        
        tuning[0] = createTone(Note.E, 1);
        tuning[1] = createTone(Note.B, 0);
        tuning[2] = createTone(Note.G, 0);
        tuning[3] = createTone(Note.D, 0);
        tuning[4] = createTone(Note.A, -1);
        tuning[5] = createTone(Note.E, -1);
    }

    private Tone createTone(Note note, int octave) {
        Tone tone = new Tone(note, octave);
        
        return tone;
    }
}
