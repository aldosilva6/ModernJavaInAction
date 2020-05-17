package br.com.aldo.study.j8.stream;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class TestDish {

	public static void main(String[] args) {
		List<Dish> menu = MenuUtils.getListMenu();

		List<String> threeHighCaloricDishNames = menu.stream().filter(dish -> dish.getCalories() > 300)
				.map(Dish::getName).limit(3).collect(toList());

		long count = menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3).count();

		System.out.println(threeHighCaloricDishNames);
		System.out.println(count);
	}

}
