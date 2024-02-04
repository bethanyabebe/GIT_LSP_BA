// Main.java
package org.howard.edu.lsp.assignment2;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("File input:");
        try {
            // Read the input file and create name tokens
            String words = FileUtils.fileToString("src/org/howard/edu/lsp/assignment2/words.txt");
            Map<String, Integer> wordCount = FileUtils.countWords(words);
            
            // Display word count results
            System.out.println("\nOutput:");
            FileUtils.displayWordCount(wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
