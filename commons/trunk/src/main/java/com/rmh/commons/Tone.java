package com.rmh.commons;

public class Tone {
    
    private Note note;
    private int octave;
    
    public Tone(Note note, int octave) {
        this.note = note;
        this.octave = octave;
    }

    public Note getNote() {
        return note;
    }

    public int getOctave() {
        return octave;
    }
    
    
}
