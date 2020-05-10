package br.com.aldo.study.j8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.aldo.study.enums.AppleColor;

public class TestApple {
	
	public static void main(String[] args) {
		List<Apple> listApple = getAllApples();
		
		System.out.println(filterApple(listApple, Apple::isRedApple).size());
		System.out.println(filterApple(listApple, Apple::isHeavy).size());
		
		//With Lambda Expression
		System.out.println(filterApple(listApple, a -> a.getColor().equals(AppleColor.RED)).size());
		System.out.println(filterApple(listApple, a -> a.getWeight() > Long.valueOf("15")).size());
		
	}
	
	public static List<Apple> filterApple(List<Apple> inventory, Predicate<Apple> p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory) {
			if(p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public static boolean isRedAppleStatic(Apple apple) {
		return AppleColor.RED.equals(apple.getColor());
	}
	
	private static List<Apple> getAllApples(){
		List<Apple> listApple = new ArrayList<>();
		Apple appleBlue = new Apple(AppleColor.BLUE, Long.valueOf("10"));
		
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
