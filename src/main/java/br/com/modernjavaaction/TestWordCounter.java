package br.com.modernjavaaction;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TestWordCounter {

	public static void main(String[] args) {
		String SENTENCE = "The poet finds himself lost in a dark wood ";

		// Stream<Character> stream = IntStream.range(0,
		// SENTENCE.length()).mapToObj(SENTENCE::charAt);

		java.util.Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
		Stream<Character> stream = StreamSupport.stream(spliterator, true);

		System.out.println("Found " + countWords(stream.parallel()) + " words");

	}

	private static int countWords(Stream<Character> stream) {
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate,
				WordCounter::combine);

		return wordCounter.getCounter();
	}

}
