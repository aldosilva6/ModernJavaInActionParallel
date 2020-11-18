package br.com.modernjavaaction;

import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TestNewFactoryMethodsCollection {

	public static void main(String[] args) {
		// var check = new java.util.ArrayList<String>();
		List<String> listName = List.of("Aldo", "Emanuela", "Ricardo");
		System.out.println(listName);

		Map<String, Integer> mapOfNames = Map.of("Aldo", 33, "Emanuela", 30);
		System.out.println(mapOfNames);

		// Methods of Map

		// Before Java 8
		for (Map.Entry<String, Integer> entry : mapOfNames.entrySet()) {
			String friend = entry.getKey();
			Integer age = entry.getValue();

			System.out.println(friend + " is " + age + " years old ");
		}

		// After Java 8 forEach method
		mapOfNames.forEach((friend, age) -> System.out.println(friend + " is " + age + " years old Java 8"));

		Map<String, ArrayList<String>> favouriteMovies = Map.ofEntries(
				entry("Raphael", new ArrayList<String>(Arrays.asList("Star Wars"))),
				entry("Cristina", new ArrayList<String>(Arrays.asList("Matrix"))),
				entry("Olivia", new ArrayList<String>(Arrays.asList("James Bond"))));

		// Two new methods let you sort the entries by values or key
		// comparingByValue or comparingByKey
		favouriteMovies.entrySet().stream().sorted(Entry.comparingByKey()).forEachOrdered(System.out::println);

		// GetOrDefault method - if not exist return default
		System.out.println(favouriteMovies.getOrDefault("Olivia", new ArrayList<String>(Arrays.asList("Matrix"))));
		System.out.println(favouriteMovies.getOrDefault("Tribaut", new ArrayList<String>(Arrays.asList("Matrix"))));

		// computeIfAbsent, computeIfPresent e compute
		String friend = "Osmar";

		// Before Java 8
		Map<String, List<String>> favoriteMoviesMutable = new HashMap<String, List<String>>();
		List<String> movies = favoriteMoviesMutable.get(friend);
		if (movies == null) {
			movies = new ArrayList<>();
			favoriteMoviesMutable.put(friend, (ArrayList<String>) movies);
		}
		movies.add("Star Wars");

		// After Java 8
		favoriteMoviesMutable.computeIfAbsent("Thiago", name -> new ArrayList<>()).add("Star Wars");

		System.out.println(favoriteMoviesMutable);

		// Replace and ReplaceAll method
		Map<String, String> favouriteMoviesNew = new HashMap<>();
		favouriteMoviesNew.put("Raphael", "tomb Raider");
		favouriteMoviesNew.put("Olivia", "James Bound");
		favouriteMoviesNew.replaceAll((name, movie) -> movie.toUpperCase());

		System.out.println(favouriteMoviesNew);

		// PutAll method
		Map<String, String> family = Map.ofEntries(entry("Teo", "Who wants to be a milionarie"),
				entry("Aldo", "Hangover"));
		Map<String, String> friends = Map.ofEntries(entry("Marcela", "The Rich"), entry("Aldo", "Duplicate Movie"));
		Map<String, String> everyone = new HashMap<>(family);
		everyone.putAll(friends);

		System.out.println(everyone);

		// Merge method
		Map<String, String> familyMerge = Map.ofEntries(entry("Teo", "Who wants to be a milionarie"),
				entry("Aldo", "Hangover"));
		Map<String, String> friendsMerge = Map.ofEntries(entry("Marcela", "The Rich"),
				entry("Aldo", "Duplicate Movie"));
		Map<String, String> everyoneMerge = new HashMap<>(familyMerge);

		friendsMerge.forEach((k, v) -> everyoneMerge.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
		System.out.println(everyoneMerge);

	}

}
