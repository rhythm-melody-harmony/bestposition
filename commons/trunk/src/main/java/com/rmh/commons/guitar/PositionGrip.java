package com.rmh.commons.guitar;

import com.rmh.commons.guitar.Position;

public class PositionGrip {
    
    private Position position;
    private int finger;
    
    public PositionGrip(Position position, int finger) {
        this.position = position;
        this.finger = finger;
    }

    public Position getPosition() {
        return position;
    }

    public int getFinger() {
        return finger;
    }
    
}
