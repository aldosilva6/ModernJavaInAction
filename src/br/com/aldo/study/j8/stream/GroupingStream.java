package br.com.aldo.study.j8.stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class GroupingStream {

	public enum CaloricLevel {
		DIET, NORMAL, FAT
	}

	public static void main(String[] args) {
		List<Dish> menu = MenuUtils.getListMenu();

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

		System.out.println("By Caloric Level:" + dishesByTypeCaloricLevel);

		// Subgrouping
		// Count by Type
		Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
		System.out.println(typesCount);

		// Most Caloric by Type - Optional problem
		Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
				.collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

		System.out.println(mostCaloricByType);

		Map<Dish.Type, Dish> mostCaloricByTypeOnlyDish = menu.stream().collect(
				groupingBy(Dish::getType, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));

		System.out.println(mostCaloricByTypeOnlyDish);

		// Sum only the total calories by Type
		Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
				.collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

		System.out.println(totalCaloriesByType);

		// Grouping with transformation
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelByType = menu.stream()
				.collect(groupingBy(Dish::getType, mapping(dish -> {
					if (dish.getCalories() <= 400)
						return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
						return CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
				}, toSet())));

		System.out.println(caloricLevelByType);

		// Grouping with transformation specifying the type of Set
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelByTypeHashSet = menu.stream()
				.collect(groupingBy(Dish::getType, mapping(dish -> {
					if (dish.getCalories() <= 400)
						return CaloricLevel.DIET;
					else if (dish.getCalories() <= 700)
						return CaloricLevel.NORMAL;
					else
						return CaloricLevel.FAT;
				}, toCollection(HashSet::new))));

		System.out.println(caloricLevelByTypeHashSet);
	}

}
