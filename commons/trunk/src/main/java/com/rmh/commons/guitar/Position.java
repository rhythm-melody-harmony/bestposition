package com.rmh.commons.guitar;

import com.rmh.commons.guitar.PositionPoint;

public class Position {
    
    private PositionPoint position;
    private int finger;
    
    public Position(PositionPoint position, int finger) {
        this.position = position;
        this.finger = finger;
    }

    public PositionPoint getPosition() {
        return position;
    }

    public int getFinger() {
        return finger;
    }
    
}
