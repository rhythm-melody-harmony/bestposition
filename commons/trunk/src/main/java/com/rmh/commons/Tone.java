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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.note != null ? this.note.hashCode() : 0);
        hash = 79 * hash + this.octave;
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
        final Tone other = (Tone) obj;
        if (this.note != other.note) {
            return false;
        }
        if (this.octave != other.octave) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tone{" + "note=" + note + ", octave=" + octave + '}';
    }
    
}
