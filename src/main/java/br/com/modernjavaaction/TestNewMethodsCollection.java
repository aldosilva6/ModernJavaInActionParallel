package br.com.modernjavaaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.modernjavaaction.model.Transaction;

public class TestNewMethodsCollection {

	public static void main(String[] args) {
		Transaction s1 = new Transaction();
		s1.setReferenceCode("123564");
		Transaction s2 = new Transaction();
		s2.setReferenceCode("ab");
		Transaction s3 = new Transaction();
		s3.setReferenceCode("abc");
		Transaction s4 = new Transaction();
		s4.setReferenceCode("abcd");
		Transaction s5 = new Transaction();
		s5.setReferenceCode("abcde");

		List<Transaction> transactions = new ArrayList<>(java.util.Arrays.asList(s1, s2, s3, s4, s5));

		/*
		 * for (Transaction transaction : transactions) { if
		 * (Character.isDigit(transaction.getReferenceCode().charAt(0))) {
		 * transactions.remove(transaction); } }
		 */

		// To Solve UnsupportedOperation

		/*
		 * for (Iterator<Transaction> iterator = transactions.iterator();
		 * iterator.hasNext();) { Transaction transaction = iterator.next(); if
		 * (Character.isDigit(transaction.getReferenceCode().charAt(0))) {
		 * iterator.remove(); } }
		 */

		// Using removeIf and referenceCodes from Java 8
		transactions.removeIf(transaction -> //
		Character.isDigit(transaction.getReferenceCode().charAt(0)));

		transactions.replaceAll(new MyUnaryOperatorToTransaction());

		transactions.forEach(transaction -> System.out.println(transaction.getReferenceCode()));

		List<String> nomes = new ArrayList<String>(Arrays.asList("aldo", "paulo", "manu"));
		nomes.replaceAll(nome -> nome.toUpperCase());

		nomes.forEach(System.out::println);

	}

}
