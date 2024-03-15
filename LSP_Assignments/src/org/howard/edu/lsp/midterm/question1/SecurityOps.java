package org.howard.edu.lsp.midterm.question1;

/**
 * Class responsible for security operations.
 */
public class SecurityOps {
    /**
     * Encrypts text by writing all even-index characters followed by all odd index characters, ignoring punctuation and whitespace.
     *
     * @param text The string to be encrypted
     * @return the encrypted string based on the aforementioned requirements, of String type.
     */
	public static String encrypt(String text) {
		
		// StringBuilders to separate even and odd chars
		StringBuilder evenChars = new StringBuilder();
		StringBuilder oddChars = new StringBuilder();
		
		// remove spaces & punctuation
        String regex = "[\\p{Punct}\\s]";
        text = text.replaceAll(regex, "");

		// iterate through each character of the supplied string
		for (int i = 0; i< text.length(); i++)
		{
			
			// check that current character is not punctuation/whitespace
			char currChar = text.charAt(i);
			if (i % 2 == 0)
			{
				evenChars.append(currChar);
			} else {
				oddChars.append(currChar);
			}
		}
		// return even characters first, followed by odd characters
		return evenChars.toString() + oddChars.toString();
	}
}
