package com.rmh.bestpositionapp;

import com.rmh.bestpositionapp.file.FileLoader;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main( String[] args ) throws IOException {
        if (args.length == 0) {
            System.out.println( "You must specify source file" );
            return;
        }
        
        String sourceFilePath = args[0];
        FileLoader fileLoader = new FileLoader();
        List<String> source = fileLoader.loadFile(sourceFilePath);
        
        BestPosition bestPosition = new BestPosition();
        List<String> results = bestPosition.run(source);
        
        printResults(results);
    }

    private static void printResults(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
        
        System.out.println("Best position App executed successfuly");
    }
}
