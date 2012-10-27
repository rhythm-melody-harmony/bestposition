package com.rmh.bestposition.processor.impl;

import com.rmh.bestposition.utils.DataBuilder;
import com.rmh.commons.Tone;
import com.rmh.commons.guitar.FretBoard;
import com.rmh.commons.guitar.Position;
import com.rmh.commons.guitar.PositionPoint;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class PhrasePositionsFinderTest {
    
    @Test
    public void testFindPositions() {
        List<PositionPoint> fretBoard = (new FretBoard()).getPositions();
        List<Tone> phrase = DataBuilder.buildTestPhrase();
        boolean useThumbFinger = false;
        boolean useOpenStrings = false;
        
        PhrasePositionsFinder phrasePositionsFinder = new PhrasePositionsFinder(fretBoard, useThumbFinger, useOpenStrings);
        
        List<Position> positions = phrasePositionsFinder.findPositions(phrase);
        
        assertNotNull(positions);
        
        assertEquals(104, positions.size());
        
        assertEquals(3, positions.get(0).getPosition().getFret());
        assertEquals(5, positions.get(0).getPosition().getString());
        assertEquals(1, positions.get(0).getFinger());
        
        assertEquals(3, positions.get(1).getPosition().getFret());
        assertEquals(5, positions.get(1).getPosition().getString());
        assertEquals(2, positions.get(1).getFinger());
        
        assertEquals(3, positions.get(2).getPosition().getFret());
        assertEquals(5, positions.get(2).getPosition().getString());
        assertEquals(3, positions.get(2).getFinger());
        
        assertEquals(3, positions.get(3).getPosition().getFret());
        assertEquals(5, positions.get(3).getPosition().getString());
        assertEquals(4, positions.get(3).getFinger());
        
        assertEquals(20, positions.get(100).getPosition().getFret());
        assertEquals(6, positions.get(100).getPosition().getString());
        assertEquals(1, positions.get(100).getFinger());
        
        assertEquals(20, positions.get(101).getPosition().getFret());
        assertEquals(6, positions.get(101).getPosition().getString());
        assertEquals(2, positions.get(101).getFinger());
        
        assertEquals(20, positions.get(102).getPosition().getFret());
        assertEquals(6, positions.get(102).getPosition().getString());
        assertEquals(3, positions.get(102).getFinger());
        
        assertEquals(20, positions.get(103).getPosition().getFret());
        assertEquals(6, positions.get(103).getPosition().getString());
        assertEquals(4, positions.get(103).getFinger());
    }
    
    @Test
    public void testFindPositionsWhenThumbIsInUse() {
        List<PositionPoint> fretBoard = (new FretBoard()).getPositions();
        List<Tone> phrase = DataBuilder.buildThumbTestPhrase();
        boolean useThumbFinger = true;
        boolean useOpenStrings = false;
        
        PhrasePositionsFinder phrasePositionsFinder = new PhrasePositionsFinder(fretBoard, useThumbFinger, useOpenStrings);
        
        List<Position> positions = phrasePositionsFinder.findPositions(phrase);
        
        assertNotNull(positions);
        
        assertEquals(18, positions.size());
        
        assertEquals(3, positions.get(0).getPosition().getFret());
        assertEquals(5, positions.get(0).getPosition().getString());
        assertEquals(1, positions.get(0).getFinger());
        
        assertEquals(3, positions.get(1).getPosition().getFret());
        assertEquals(5, positions.get(1).getPosition().getString());
        assertEquals(2, positions.get(1).getFinger());
        
        assertEquals(3, positions.get(2).getPosition().getFret());
        assertEquals(5, positions.get(2).getPosition().getString());
        assertEquals(3, positions.get(2).getFinger());
        
        assertEquals(3, positions.get(3).getPosition().getFret());
        assertEquals(5, positions.get(3).getPosition().getString());
        assertEquals(4, positions.get(3).getFinger());
        
        assertEquals(8, positions.get(4).getPosition().getFret());
        assertEquals(6, positions.get(4).getPosition().getString());
        assertEquals(1, positions.get(4).getFinger());
        
        assertEquals(8, positions.get(5).getPosition().getFret());
        assertEquals(6, positions.get(5).getPosition().getString());
        assertEquals(2, positions.get(5).getFinger());
        
        assertEquals(8, positions.get(6).getPosition().getFret());
        assertEquals(6, positions.get(6).getPosition().getString());
        assertEquals(3, positions.get(6).getFinger());
        
        assertEquals(8, positions.get(7).getPosition().getFret());
        assertEquals(6, positions.get(7).getPosition().getString());
        assertEquals(4, positions.get(7).getFinger());
        
        assertEquals(8, positions.get(8).getPosition().getFret());
        assertEquals(6, positions.get(8).getPosition().getString());
        assertEquals(5, positions.get(8).getFinger());
    }
    
    @Test
    public void testFindPositionsWhenOpenStringsAreInUse() {
        List<PositionPoint> fretBoard = (new FretBoard()).getPositions();
        List<Tone> phrase = DataBuilder.buildOpenStringsTestPhrase();
        boolean useThumbFinger = false;
        boolean useOpenStrings = true;
        
        PhrasePositionsFinder phrasePositionsFinder = new PhrasePositionsFinder(fretBoard, useThumbFinger, useOpenStrings);
        
        List<Position> positions = phrasePositionsFinder.findPositions(phrase);
        
        assertNotNull(positions);
        
        assertEquals(62, positions.size());
        
        assertEquals(0, positions.get(0).getPosition().getFret());
        assertEquals(1, positions.get(0).getPosition().getString());
        assertEquals(-1, positions.get(0).getFinger());
        
        assertEquals(5, positions.get(1).getPosition().getFret());
        assertEquals(2, positions.get(1).getPosition().getString());
        assertEquals(1, positions.get(1).getFinger());
        
        assertEquals(5, positions.get(2).getPosition().getFret());
        assertEquals(2, positions.get(2).getPosition().getString());
        assertEquals(2, positions.get(2).getFinger());
        
        assertEquals(5, positions.get(3).getPosition().getFret());
        assertEquals(2, positions.get(3).getPosition().getString());
        assertEquals(3, positions.get(3).getFinger());
        
        assertEquals(5, positions.get(4).getPosition().getFret());
        assertEquals(2, positions.get(4).getPosition().getString());
        assertEquals(4, positions.get(4).getFinger());
        
        assertEquals(9, positions.get(5).getPosition().getFret());
        assertEquals(3, positions.get(5).getPosition().getString());
        assertEquals(1, positions.get(5).getFinger());
        
        assertEquals(0, positions.get(17).getPosition().getFret());
        assertEquals(2, positions.get(17).getPosition().getString());
        assertEquals(-1, positions.get(17).getFinger());
        
        assertEquals(4, positions.get(18).getPosition().getFret());
        assertEquals(3, positions.get(18).getPosition().getString());
        assertEquals(1, positions.get(18).getFinger());
    }
}
