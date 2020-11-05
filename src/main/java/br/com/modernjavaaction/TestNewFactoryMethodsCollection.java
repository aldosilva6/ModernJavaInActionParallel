package br.com.modernjavaaction;

import java.util.List;
import java.util.Map;

public class TestNewFactoryMethodsCollection {

	public static void main(String[] args) {
		// var check = new java.util.ArrayList<String>();
		List<String> listName = List.of("Aldo", "Emanuela", "Ricardo");
		System.out.println(listName);

		Map<String, Integer> mapOfNames = Map.of("Aldo", 33, "Emanuela", 30);
		System.out.println(mapOfNames);

	}

}
