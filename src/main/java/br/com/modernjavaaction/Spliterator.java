package br.com.modernjavaaction;

public class Spliterator {

	public static void main(String[] args) {
		String SENTENCE = "The poet finds himself lost in a dark wood ";
		System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
	}

	public static int countWordsIteratively(String s) {
		int counter = 0;
		boolean lastSpace = true;
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) {
				lastSpace = true;
			} else {
				if (lastSpace)
					counter++;
				lastSpace = false;
			}
		}
		return counter;
	}

}
