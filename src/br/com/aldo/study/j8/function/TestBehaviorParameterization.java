package br.com.aldo.study.j8.function;

import java.util.ArrayList;
import java.util.List;

import br.com.aldo.study.enums.AppleColor;

public class TestBehaviorParameterization {
	
	public static void main(String[] args) {
		List<Apple> listApple = getAllApples();
		
		prettyPrintApple(listApple, new AppleFancyFormat());
		prettyPrintApple(listApple, new AppleSimpleFormat());
	}
	
	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter format) {
		for(Apple apple : inventory) {
			String output = format.accept(apple);
			System.out.println(output);
		}
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
