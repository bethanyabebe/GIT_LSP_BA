package org.howard.edu.lsp.midterm.question1;

public class Driver {
	public static void main(String[] args) {
        String originalText = "I love CSCI363"; //IoeS16lvCC33

        String encryptedText = SecurityOps.encrypt(originalText);

        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + encryptedText);
	}
}
