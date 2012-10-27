package com.rmh.bestpositionapp.file;

import java.net.URL;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class FileLoaderTest {
    
    @Test
    public void testLoadFile() throws Exception {
        FileLoader fileLoader = new FileLoader();
        
        URL url = this.getClass().getResource("/test_source.txt");
        String filePath = url.getPath();
        
        if (filePath.charAt(0) == '/') {
            filePath = filePath.substring(1);
        }
        
        List<String> source = fileLoader.loadFile(filePath);
        
        assertNotNull(source);
        assertEquals(2, source.size());
        assertEquals("C/0", source.get(0));
        assertEquals("D/0", source.get(1));
    }
}
