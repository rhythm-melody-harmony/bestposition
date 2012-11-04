package com.rmh.bestpositionapp.converter;

import com.rmh.commons.guitar.Position;
import java.util.ArrayList;
import java.util.List;

public class BestPositionsConverter {
    
    public List<String> convert(List<Position> positionsList) {
        List<String> result = new ArrayList<String>();
        
      //  for (List<Position> positions : positionsList) {
            String line = convertLine(positionsList);
            result.add(line);
       // }
        
        return result;
    }

    private String convertLine(List<Position> positions) {
        StringBuilder resultBuilder = new StringBuilder();
        
        for (Position position : positions) {
            String line = position.getPosition().getFret() + "/" + position.getPosition().getString() + "/" + position.getFinger();
            
            if (resultBuilder.length() > 0) {
                resultBuilder.append(", ");
            }
            
            resultBuilder.append(line);
        }
        
        return resultBuilder.toString();
    }
    
}
