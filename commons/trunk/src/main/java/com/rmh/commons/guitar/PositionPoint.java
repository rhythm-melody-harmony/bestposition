package com.rmh.commons.guitar;

import com.rmh.commons.Tone;

public class PositionPoint {
    
    private Tone tone;
    private int fret;
    private int string;
    
    public PositionPoint(Tone tone, int fret, int string) {
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
