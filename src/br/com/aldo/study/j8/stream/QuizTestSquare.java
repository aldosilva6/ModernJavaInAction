package br.com.aldo.study.j8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuizTestSquare {

	public static void main(String[] args) {
		List<Integer> square = Arrays.asList(1, 2, 3, 4, 5, 6);

		square.stream().map(i -> i*i).sorted().forEach(System.out::println);

		List<Integer> numbersOne = Arrays.asList(1, 2, 3);
		List<Integer> numbersTwo = Arrays.asList(3, 4);

		List<int[]> pairs = numbersOne.stream().flatMap(n -> numbersTwo.stream()
				.filter(j -> (j+n) % 3 == 0)
				.map(j -> new int[] { n, j }))
				.collect(Collectors.toList());

		for (int[] array : pairs) {
			System.out.println(Arrays.toString(array));
		}
		
	}

}
