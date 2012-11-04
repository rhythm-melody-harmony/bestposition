package com.rmh.bestpositionapp.converter;

import com.rmh.commons.Note;
import com.rmh.commons.Tone;
import com.rmh.commons.guitar.Position;
import com.rmh.commons.guitar.PositionPoint;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class BestPositionsConverterTest {
    
    @Test
    public void testConvert() {
        BestPositionsConverter bestPositionsConverter = new BestPositionsConverter();
        List<Position> positionsList = buildPositions();
        
        List<String> convertedList = bestPositionsConverter.convert(positionsList);
        
        assertNotNull(convertedList);
        assertEquals(1, convertedList.size());
        assertEquals("1/6/1, 3/6/3", convertedList.get(0));
    }

    private List<List<Position>> buildPositionsList() {
        List<List<Position>> results = new ArrayList<List<Position>>();
        
        List<Position> positions = buildPositions();
        results.add(positions);
        
        positions = buildPositions();
        results.add(positions);
        
        return results;
    }

    private List<Position> buildPositions() {
        List<Position> positions = new ArrayList<Position>();
        
        PositionPoint positionPoint = new PositionPoint(new Tone(Note.E, -1), 1, 6);
        Position position = new Position(positionPoint, 1);
        positions.add(position);
        
        positionPoint = new PositionPoint(new Tone(Note.G, -1), 3, 6);
        position = new Position(positionPoint, 3);
        positions.add(position);
        
        return positions;
    }
}
