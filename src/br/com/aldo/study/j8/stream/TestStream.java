package br.com.aldo.study.j8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("HELLO", "WORLD");

		List<String> listOfCharacters = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList());

		listOfCharacters.forEach(System.out::println);
		
		int size = listOfCharacters.size();
		
		System.out.println(size);
	}
}
