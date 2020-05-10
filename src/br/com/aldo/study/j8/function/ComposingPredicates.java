package br.com.aldo.study.j8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.aldo.study.enums.AppleColor;

public class ComposingPredicates {
	
	public static void main(String[] args) {
		List<Apple> listApple = getAllApples();
		
		Predicate<Apple> appleRed = (Apple apple) -> apple.getColor().equals(AppleColor.RED);
		
		List<Apple> onlyAppleReds = filterApple(listApple, appleRed);
		
		onlyAppleReds.forEach((x) -> System.out.println(x.getWeight()));
		
		System.out.println("*********************** Composed Predicate Negate **********************");
		
		//Using negate default method
		List<Apple> otherThanRed = filterApple(listApple, appleRed.negate());
		
		otherThanRed.forEach((x) -> System.out.println(x.getWeight()));
		
		System.out.println("*********************** Composed Predicate And **********************");
		
		//Composed Predicate
		Predicate<Apple> appleRedAndBlue = appleRed.or((a) -> a.getColor().equals(AppleColor.BLUE));
		
		List<Apple> listAppleRedAndBlue = filterApple(listApple, appleRedAndBlue);
		
		listAppleRedAndBlue.forEach((x) -> System.out.println(x.getWeight()));
		
		System.out.println("*********************** Composed Predicate And **********************");
		
		//Composed Predicate
		Predicate<Apple> appleRedAndBlueAndHeavy = appleRedAndBlue.and(a -> a.getWeight() > Long.valueOf("15"));
		
		List<Apple> listAppleRedAndBlueAndHeavy = filterApple(listApple, appleRedAndBlueAndHeavy);
		
		listAppleRedAndBlueAndHeavy.forEach((x) -> System.out.println(x.getWeight()));
		
	}
	
	public static List<Apple> filterApple(List<Apple> list, Predicate<Apple> p){
		List<Apple> result = new ArrayList<>();
		for(Apple a : list) {
			if(p.test(a)) {
				result.add(a);
			}
		}
		
		return result;
	}
	
	
	private static List<Apple> getAllApples(){
		List<Apple> listApple = new ArrayList<>();
		Apple appleBlue = new Apple(AppleColor.BLUE, Long.valueOf("15"));
		
		Apple appleGreen = new Apple(AppleColor.GREEN, Long.valueOf("20"));
		
		Apple appleRed = new Apple(AppleColor.RED, Long.valueOf("18"));
		
		Apple appleRed3 = new Apple(AppleColor.RED, Long.valueOf("10"));

		listApple.add(appleBlue);
		listApple.add(appleRed3);
		listApple.add(appleGreen);
		listApple.add(appleRed);
		
		return listApple;
	}

}
