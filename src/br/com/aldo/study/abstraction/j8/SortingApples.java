package br.com.aldo.study.abstraction.j8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import br.com.aldo.study.enums.AppleColor;
import br.com.aldo.study.j8.function.Apple;

public class SortingApples {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(AppleColor.GREEN, Long.valueOf("15")),
				new Apple(AppleColor.GREEN, Long.valueOf("20")), new Apple(AppleColor.RED, Long.valueOf("18")));

		// Sorting with anonymous class
		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		});

		System.out.println("Sorted:");
		inventory.forEach(a -> System.out.println(a.getWeight()));
		System.out.println("Finished");
		
		List<Apple> inventoryNew = Arrays.asList(new Apple(AppleColor.GREEN, Long.valueOf("15")),
				new Apple(AppleColor.GREEN, Long.valueOf("20")), new Apple(AppleColor.RED, Long.valueOf("18")));
		
		System.out.println("Before sorting");
		inventoryNew.forEach(a -> System.out.println(a.getWeight()));
		
		System.out.println("Sorted:");
		inventoryNew.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
		inventoryNew.forEach(a -> System.out.println(a.getWeight()));
		System.out.println("Finished");
		
		
	}

}
