package br.com.aldo.study.abstraction.j8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import br.com.aldo.study.enums.AppleColor;
import br.com.aldo.study.j8.function.Apple;

public class FilteringAnyThing {
	
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(AppleColor.GREEN, Long.valueOf("15")),
				new Apple(AppleColor.GREEN, Long.valueOf("20")), new Apple(AppleColor.RED, Long.valueOf("18")));
		
		List<Apple> redApple = filter(inventory, (Apple a) -> AppleColor.RED.equals(a.getColor()));
		System.out.println(redApple.size());

		
		//Accept Anything
		List<Integer> listIntegers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> evenNumbers = filter(listIntegers, (Integer i) -> i % 2 == 0);
		evenNumbers.forEach(i -> System.out.println(i));
		
	}
	
	public static <T> List<T> filter(List<T> inventory, Predicate<T> p){
		List<T> result = new ArrayList<>();
		for(T t : inventory) {
			if(p.test(t)) {
				result.add(t);
			}
		}
		
		return result;
	}

}
