package com.rmh.bestposition.processor.impl;

import com.rmh.commons.Tone;
import com.rmh.commons.guitar.Position;
import com.rmh.commons.guitar.PositionPoint;
import java.util.ArrayList;
import java.util.List;

public class PhrasePositionsFinder {
    
    private List<PositionPoint> fretBoard;
    private boolean useThumbFinger;
    private boolean useOpenStrings;
    private int numberOfStrings;
    
    public PhrasePositionsFinder(List<PositionPoint> fretBoard, boolean useThumbFinger, boolean useOpenStrings) {
        this.fretBoard = fretBoard;
        this.useThumbFinger = useThumbFinger;
        this.useOpenStrings = useOpenStrings;
        
        countNumberOfStrings();
    }
    
    public List<Position> findPositions(List<Tone> phrase) {
        List<Position> positions = new ArrayList<Position>();
        
        for (Tone tone : phrase) {
            List<Position> tonePositions = findTonePositions(tone);
            positions.addAll(tonePositions);
        }
        
        return positions;
    }

    private List<Position> findTonePositions(Tone tone) {
        List<Position> positions = new ArrayList<Position>();
        
        for (PositionPoint positionPoint : fretBoard) {
            if (isPositionPointFound(tone, positionPoint)) {
                List<Position> tonePositions = addFingersToPositionPoint(positionPoint);
                positions.addAll(tonePositions);
            }
        }
        
        return positions;
    }
    
    private boolean isPositionPointFound(Tone tone, PositionPoint positionPoint) {
        boolean result = false;
        
        if (useOpenStrings || positionPoint.getFret() > 0) {
            if (tone.equals(positionPoint.getTone())) {
                result = true;
            }
        }
        
        return result;
    }
    
    private List<Position> addFingersToPositionPoint(PositionPoint positionPoint) {
        List<Position> positions = new ArrayList<Position>();
        
        if (positionPoint.getFret() == 0) {
            addPositionForOpenString(positions, positionPoint);
        } else {
            addPositionsWithFingers(positions, positionPoint);
        }
        
        return positions;
    }
    
    private void addPositionForOpenString(List<Position> positions, PositionPoint positionPoint) {
        Position position = new Position(positionPoint, -1);
        positions.add(position);
    }
    
    private void addPositionsWithFingers(List<Position> positions, PositionPoint positionPoint) {
        int numberOfFingers = 4;
        if (useThumbFinger && numberOfStrings == positionPoint.getString()) {
            numberOfFingers = 5;
        }
        
        for (int i = 1; i <= numberOfFingers; i++) {
            Position position = new Position(positionPoint, i);
            positions.add(position);
        }
    }

    private void countNumberOfStrings() {
        int result = 0;
        
        for (PositionPoint positionPoint : fretBoard) {
            if (positionPoint.getFret() == 0) {
                result++;
            }
        }
        
        numberOfStrings = result;
    }

}
