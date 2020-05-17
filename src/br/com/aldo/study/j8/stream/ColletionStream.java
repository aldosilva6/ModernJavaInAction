package br.com.aldo.study.j8.stream;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

public class ColletionStream {

	public static void main(String[] args) {
		List<Dish> menu = MenuUtils.getListMenu();

		// How many dishes?
		Long total = menu.stream().collect(counting());
		System.out.println(total);

		// With Reduction. LESS READABLE
		Optional<Dish> mostCalorieDish = menu.stream()
				.collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
		System.out.println(mostCalorieDish.get());

		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> collect = menu.stream().collect(maxBy(dishCaloriesComparator));

		// The higest-calorie dish
		Dish dish = collect.get();
		System.out.println(dish);

		// With Reduction. LESS READABLE
		int totalCaloriesWithReduction = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
		System.out.println(totalCaloriesWithReduction);
		// Or
		int totalCaloriesWithReductionUsingSumFromInteger = menu.stream()
				.collect(reducing(0, Dish::getCalories, Integer::sum));
		System.out.println(totalCaloriesWithReductionUsingSumFromInteger);

		// Sum of calories
		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println(totalCalories);
		// Or using IntStream
		int totalCaloriesDishes = menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println(totalCaloriesDishes);

		// Average
		Double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
		System.out.println(avgCalories);

		// Class with statistics about a string
		IntSummaryStatistics intSummaryStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println(intSummaryStatistics);

		String shortMenuUsingReduction = menu.stream().map(Dish::getName).collect(reducing((d1, d2) -> d1 + d2)).get();
		System.out.println(shortMenuUsingReduction);
		// Or without Optional
		String shortMenuReductionThreeArgs = menu.stream().collect(reducing("", Dish::getName, (d1, d2) -> d1 + d2));
		System.out.println(shortMenuReductionThreeArgs);

		// Joining Strings - More readable and better performance
		String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
		System.out.println(shortMenu);

	}

}
