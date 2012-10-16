package com.rmh.commons.guitar;

import com.rmh.commons.Tone;

public class Position {
    
    private Tone tone;
    private int fret;
    private int string;
    private int finger;
    
    public Position(Tone tone, int fret, int string, int finger) {
        this.tone = tone;
        this.fret = fret;
        this.string = string;
        this.finger = finger;
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

    public int getFinger() {
        return finger;
    }
    
}
