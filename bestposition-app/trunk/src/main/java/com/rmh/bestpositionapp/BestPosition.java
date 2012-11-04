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
import com.rmh.commons.guitar.ToneEdge;
import com.rmh.commons.guitar.ToneVertex;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BestPosition {
    
    public List<String> run(List<String> source) throws IOException {
        
        PhraseConverter phraseConverter = new PhraseConverter();
        List<Tone> phrase = phraseConverter.convert(source);
        List<PositionPoint> fretBoard = (new FretBoard()).getPositions();
        List<ToneVertex> nodes = new ArrayList<ToneVertex>();
        List<ToneEdge> edges = new ArrayList<ToneEdge>();
        Processor processor = new ProcessorImpl(fretBoard, nodes, edges);
        List<Position> bestPositions = processor.run(phrase);
        
        BestPositionsConverter bestPositionsConverter = new BestPositionsConverter();
        List<String> result = bestPositionsConverter.convert(bestPositions);
        
        return result;
    }
    
}
