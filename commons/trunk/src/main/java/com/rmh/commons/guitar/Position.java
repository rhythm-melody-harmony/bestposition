package com.rmh.commons.guitar;

import com.rmh.commons.Tone;

public class Position {
    
    private Tone tone;
    private int fret;
    private int string;
    
    public Position(Tone tone, int fret, int string) {
        this.tone = tone;
        this.fret = fret;
        this.string = string;
    }

    public Tone getTone() {
        return tone;
    }

    public int getFret() {
        return fret;
    }

    public int getString() {
        return string;
    }
    
}
