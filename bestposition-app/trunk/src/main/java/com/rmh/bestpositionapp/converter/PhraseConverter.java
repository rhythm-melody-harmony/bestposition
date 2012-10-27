package com.rmh.bestpositionapp.converter;

import com.rmh.commons.Note;
import com.rmh.commons.Tone;
import java.util.ArrayList;
import java.util.List;

public class PhraseConverter {
    
    public List<Tone> convert(List<String> phrase) {
        List<Tone> tones = new ArrayList<Tone>();
        
        for (String phraseTone : phrase) {
            Tone tone = convertTone(phraseTone);
            tones.add(tone);
        }
        
        return tones;
    }

    private Tone convertTone(String phraseTone) {
        String[] phraseSplit = phraseTone.split("/");
        
        Note note = Note.fromString(phraseSplit[0]);
        int octave = Integer.parseInt(phraseSplit[1]);
        
        Tone tone = new Tone(note, octave);
        
        return tone;
    }
    
}
