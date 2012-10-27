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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.position != null ? this.position.hashCode() : 0);
        hash = 67 * hash + this.finger;
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
        final Position other = (Position) obj;
        if (this.position != other.position && (this.position == null || !this.position.equals(other.position))) {
            return false;
        }
        if (this.finger != other.finger) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Position{" + "position=" + position + ", finger=" + finger + '}';
    }
    
}
