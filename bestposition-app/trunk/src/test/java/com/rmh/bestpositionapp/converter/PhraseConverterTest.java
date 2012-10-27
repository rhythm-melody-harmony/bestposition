package com.rmh.bestpositionapp.converter;

import com.rmh.commons.Note;
import com.rmh.commons.Tone;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PhraseConverterTest {
    
    @Test
    public void testConvert() {
        PhraseConverter phraseConverter = new PhraseConverter();
        
        List<String> phrase = new ArrayList<String>();
        phrase.add("C/0");
        phrase.add("C#/1");
        
        List<Tone> tones = phraseConverter.convert(phrase);
        
        assertNotNull(tones);
        assertEquals(2, tones.size());
        
        assertEquals(Note.C, tones.get(0).getNote());
        assertEquals(0, tones.get(0).getOctave());
        
        assertEquals(Note.CSharp, tones.get(1).getNote());
        assertEquals(1, tones.get(1).getOctave());
    }
}
