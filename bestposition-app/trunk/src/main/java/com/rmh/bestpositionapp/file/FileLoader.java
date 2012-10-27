package com.rmh.bestpositionapp.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileLoader {
    
    public List<String> loadFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        
        return lines;
    }
    
}
