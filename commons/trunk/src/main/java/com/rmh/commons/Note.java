package com.rmh.commons;

public enum Note {
    
    C("C"), 
    CSharp("C#"), 
    D("D"), 
    DSharp("D#"), 
    E("E"), 
    F("F"), 
    FSharp("F#"), 
    G("G"), 
    GSharp("G#"),
    A("A"), 
    ASharp("A#"), 
    B("B");
    
    private String label;
    
    Note(String label) {
        this.label = label;
    }
    
    @Override
    public String toString() {
        return label;
    }
}
