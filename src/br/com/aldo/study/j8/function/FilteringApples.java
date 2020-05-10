package br.com.aldo.study.j8.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.aldo.study.enums.AppleColor;

public class FilteringApples {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(AppleColor.GREEN, Long.valueOf("15")),
				new Apple(AppleColor.GREEN, Long.valueOf("20")), new Apple(AppleColor.RED, Long.valueOf("18")));
		
		System.out.println(filterApple(inventory, new AppleHeavyWeightPredicate()).size());
		System.out.println(filterApple(inventory, new AppleGreenColorPredicate()).size());
		
		//With anonymous class
		List<Apple> listApple = filterApple(inventory, new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				return apple.getColor().equals(AppleColor.GREEN);
			}
		});
		
		System.out.println(listApple.size());
	}
	
	public static List<Apple> filterApple(List<Apple> inventory, ApplePredicate predicate){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(predicate.test(apple)) {
				result.add(apple);
			}
		}
		
		return result;
	}

}
