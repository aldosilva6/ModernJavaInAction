package br.com.aldo.study.j8.stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

import java.util.List;
import java.util.Map;

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

		// Most caloric dish by type
	}

}
