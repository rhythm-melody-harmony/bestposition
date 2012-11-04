package com.rmh.webapp;

import com.rmh.bestpositionapp.BestPosition;
import com.rmh.commons.Tone;
import com.rmh.commons.guitar.Position;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author nbuser
 */

public class PhraseHandler {

    private String phrase;

    /** Creates a new instance of PhraseHandler */
    public PhraseHandler() {
       phrase = null;
    }

    public String getPhrase() {
       return phrase;
    }

    public void setPhrase(String name) {
       this.phrase = name;
    }
    public List<String> run() throws IOException{
        List<String> SplittedPhrase = Arrays.asList(phrase.split(" "));
        BestPosition bestposition = new BestPosition();
        return bestposition.run(SplittedPhrase);
    }

}