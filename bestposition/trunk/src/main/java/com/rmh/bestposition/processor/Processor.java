package com.rmh.bestposition.processor;

import com.rmh.commons.Tone;
import com.rmh.commons.guitar.Position;
import java.util.List;

public interface Processor {
    
    public List<List<Position>> run(List<Tone> phrase);
    
}
