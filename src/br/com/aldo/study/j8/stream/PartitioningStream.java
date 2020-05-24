package br.com.aldo.study.j8.stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

public class PartitioningStream {

	public static void main(String[] args) {
		Map<Boolean, List<Dish>> partitionedMenu = MenuUtils.getListMenu().stream()
				.collect(partitioningBy(Dish::isVegetarian));
		// Divide the list in two
		System.out.println(partitionedMenu);

		// Only vegetarian
		List<Dish> vegetarianDishes = partitionedMenu.get(true);
		System.out.println(vegetarianDishes);

		// Partitioning mult level - By type vegetarian and type dish
		Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = MenuUtils.getListMenu().stream()
				.collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

		System.out.println(vegetarianDishesByType);

		// Most caloric dish by type and group
		Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = MenuUtils.getListMenu().stream().collect(partitioningBy(
				Dish::isVegetarian, collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));

		System.out.println(mostCaloricPartitionedByVegetarian);

		// Partitioning by calories
		Map<Boolean, Map<Boolean, List<Dish>>> partitioningByCalories = MenuUtils.getListMenu().stream()
				.collect(partitioningBy(Dish::isVegetarian, partitioningBy(d -> d.getCalories() > 500)));

		System.out.println(partitioningByCalories);

		// Partitioning by total
		Map<Boolean, Long> partitioningByCounting = MenuUtils.getListMenu().stream()
				.collect(partitioningBy(Dish::isVegetarian, counting()));
		System.out.println(partitioningByCounting);

		System.out.println(isPrime(7));

		System.out.println(isPrimeOptimized(49));
	}

	public static boolean isPrime(int candidate) {
		return IntStream.range(2, candidate).noneMatch(c -> candidate % c == 0);
	}

	public static boolean isPrimeOptimized(int candidate) {
		int candidadeRoot = (int) Math.sqrt((double) candidate);
		return IntStream.rangeClosed(2, candidadeRoot).noneMatch(i -> candidate % i == 0);

	}
}
