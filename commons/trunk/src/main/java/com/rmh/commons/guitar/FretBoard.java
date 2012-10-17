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
    private List<Note> naturalScale = buildNaturalScale();
    
    public FretBoard(Map<String, Object> properties) {
        this();
        extractProperties(properties);
    }
    
    public FretBoard() {
        loadDefaultProperties();
    }
    
    public List<PositionPoint> getPositions() {
        List<PositionPoint> positions = new ArrayList<PositionPoint>();
        
        for (int i = 0; i < numberOfStrings; i++) {
            createString(i, positions);
        }
        
        return positions;
    }
    
    private void createString(int string, List<PositionPoint> positions) {
        for (int i = 0; i < numberOfFrets+1; i++) {
            Tone tone = createTone(string, i);
            PositionPoint position = new PositionPoint(tone, i, string+1);
            
            positions.add(position);
        }
    }
    
    private Tone createTone(int string, int fret) {
        Tone tuningTone = tuning[string];
        
        Note note = tuningTone.getNote();
        int noteIndex = naturalScale.indexOf(note);
        int octave = tuningTone.getOctave();
        
        for (int i = 0; i < fret; i++) {
           noteIndex++;
           if (noteIndex == 12) {
               noteIndex = 0;
               octave++;
           }
        }
        
        note = naturalScale.get(noteIndex);
        
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
            numberOfStrings = (Integer)properties.get(key);
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
        
        tuning[0] = laodTone(Note.E, 1);
        tuning[1] = laodTone(Note.B, 0);
        tuning[2] = laodTone(Note.G, 0);
        tuning[3] = laodTone(Note.D, 0);
        tuning[4] = laodTone(Note.A, -1);
        tuning[5] = laodTone(Note.E, -1);
    }

    private Tone laodTone(Note note, int octave) {
        Tone tone = new Tone(note, octave);
        return tone;
    }

    private List<Note> buildNaturalScale() {
        List<Note> scale = new ArrayList<Note>();
        
        scale.add(Note.C);
        scale.add(Note.CSharp);
        scale.add(Note.D);
        scale.add(Note.DSharp);
        scale.add(Note.E);
        scale.add(Note.F);
        scale.add(Note.FSharp);
        scale.add(Note.G);
        scale.add(Note.GSharp);
        scale.add(Note.A);
        scale.add(Note.ASharp);
        scale.add(Note.B);
        
        return scale;
    }
}
