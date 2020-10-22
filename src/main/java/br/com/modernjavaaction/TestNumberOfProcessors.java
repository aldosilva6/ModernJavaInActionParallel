package br.com.modernjavaaction;

public class TestNumberOfProcessors {

	public static void main(String[] args) {
		int numberOfProcess = Runtime.getRuntime().availableProcessors();

		System.out.println(numberOfProcess);
	}

}
