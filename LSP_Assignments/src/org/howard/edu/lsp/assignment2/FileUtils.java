// FileUtils.java
package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileUtils {
    public static String fileToString(String filePath) throws IOException {
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Echo file contents line-by-line and append to the StringBuilder
                System.out.println(line);
                fileContent.append(line).append("\n");
            }
        }

        return fileContent.toString();
    }
    
    public static Map<String, Integer> countWords(String fileContent) {
        // Define Linked HashMap to print words in order
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        // Split the content into lines based on newline characters
        String[] lines = fileContent.split("\\n");

        // Process each line
        for (String line : lines) {
            // Split the line into words based on non letter/numerical characters. Also splits contractions to two words
            String[] words = line.split("[^a-zA-Z0-9]");

            // Process each word
            for (String word : words) {
            	// Convert to lowercase
                word = word.toLowerCase();
                
                // Check if the word is alphabetical or alphanumeric
                if (word.matches(".*[a-zA-Z].*") && !word.matches("\\d+")) {
                	// Check if word is not trivial (<= 3 letters)
                	if (word.length() > 3) {
                		// Update word count
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
        return wordCount;
    }


    public static void displayWordCount(Map<String, Integer> wordCount) {
        // Display the word count results
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}