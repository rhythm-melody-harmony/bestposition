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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + (this.tone != null ? this.tone.hashCode() : 0);
        hash = 11 * hash + this.fret;
        hash = 11 * hash + this.string;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PositionPoint other = (PositionPoint) obj;
        if (this.tone != other.tone && (this.tone == null || !this.tone.equals(other.tone))) {
            return false;
        }
        if (this.fret != other.fret) {
            return false;
        }
        if (this.string != other.string) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "PositionPoint{" + "tone=" + tone + ", fret=" + fret + ", string=" + string + '}';
    }

}
