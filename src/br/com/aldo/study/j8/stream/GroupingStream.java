package br.com.aldo.study.j8.stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GroupingStream {

	public enum CaloricLevel {
		DIET, NORMAL, FAT
	}

	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 350, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("praws", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));

		System.out.println(dishesByType);

		// Only Dishes more than 500 calories
		Map<Dish.Type, List<Dish>> dishesByTypeMoreThan500 = menu.stream()
				.collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
		System.out.println(dishesByTypeMoreThan500);

		// Dish names by type
		Map<Dish.Type, List<String>> dishesNamesByType = menu.stream()
				.collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
		System.out.println(dishesNamesByType);

		// MultiLevelGrouping
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
				.collect(groupingBy(Dish::getType, groupingBy(dish -> {
					if (dish.getCalories() <= 400)
						return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
						return CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
				})));

		System.out.println(dishesByTypeCaloricLevel);

		// Subgrouping
		// Count by Type
		Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
		System.out.println(typesCount);

		// Most Caloric by Type
		Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
				.collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

		System.out.println(mostCaloricByType);
	}

}
