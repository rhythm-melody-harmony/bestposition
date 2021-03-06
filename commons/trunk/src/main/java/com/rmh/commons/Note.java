package com.rmh.commons;

public enum Note {
    
    A("A"), 
    ASharp("A#"), 
    B("B"),
    C("C"), 
    CSharp("C#"), 
    D("D"), 
    DSharp("D#"), 
    E("E"), 
    F("F"), 
    FSharp("F#"), 
    G("G"), 
    GSharp("G#");
    
    
    private String label;
    
    Note(String label) {
        this.label = label;
    }
    
    @Override
    public String toString() {
        return label;
    }
    
    public static Note fromString(String label) {
        
        for (Note note : Note.values()) {
            if (note.label.equals(label)) {
                return note;
            }
        }
        
        return null;
    }
}
