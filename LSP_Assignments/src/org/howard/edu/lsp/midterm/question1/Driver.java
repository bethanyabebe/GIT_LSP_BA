package org.howard.edu.lsp.midterm.question1;

public class Driver {
	public static void main(String[] args) {
        String originalText = "I love CSCI363"; //IoeS16lvCC33

        SecurityOps s = new SecurityOps();
        String encryptedText = s.encrypt(originalText);

        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + encryptedText);
	}
}
