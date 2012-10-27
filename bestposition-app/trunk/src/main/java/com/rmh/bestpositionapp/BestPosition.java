package com.rmh.bestpositionapp;

import com.rmh.bestposition.processor.Processor;
import com.rmh.bestposition.processor.impl.ProcessorImpl;
import com.rmh.bestpositionapp.converter.BestPositionsConverter;
import com.rmh.bestpositionapp.converter.PhraseConverter;
import com.rmh.bestpositionapp.file.FileLoader;
import com.rmh.commons.Tone;
import com.rmh.commons.guitar.FretBoard;
import com.rmh.commons.guitar.Position;
import com.rmh.commons.guitar.PositionPoint;
import java.io.IOException;
import java.util.List;

public class BestPosition {
    
    public List<String> run(List<String> source) throws IOException {
        
        PhraseConverter phraseConverter = new PhraseConverter();
        List<Tone> phrase = phraseConverter.convert(source);
        
        FretBoard fretBoard = new FretBoard();
        List<PositionPoint> fretBoardPositionPoints = fretBoard.getPositions();
        
        Processor processor = new ProcessorImpl(fretBoardPositionPoints);
        List<List<Position>> bestPositions = processor.run(phrase);
        
        BestPositionsConverter bestPositionsConverter = new BestPositionsConverter();
        List<String> result = bestPositionsConverter.convert(bestPositions);
        
        return result;
    }
    
}
