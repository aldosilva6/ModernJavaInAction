package br.com.aldo.study;

import java.util.ArrayList;
import java.util.List;

import br.com.aldo.study.enums.AppleColor;

public class TestApple {
	
	public static void main(String[] args) {
		List<Apple> listApple = getAllApples();
		
		System.out.println(getOnlyRedApples(listApple).size());
		System.out.println(getHeavyApples(listApple).size());
	}
	
	private static List<Apple> getAllApples(){
		List<Apple> listApple = new ArrayList<>();
		Apple appleBlue = new Apple();
		appleBlue.setColor(AppleColor.BLUE);
		appleBlue.setWeight(Long.valueOf("10"));
		
		Apple appleGreen = new Apple();
		appleGreen.setColor(AppleColor.GREEN);
		appleGreen.setWeight(Long.valueOf("20"));
		
		Apple appleRed = new Apple();
		appleRed.setColor(AppleColor.RED);
		appleRed.setWeight(Long.valueOf("18"));
		
		Apple appleRed3 = new Apple();
		appleRed3.setColor(AppleColor.RED);
		appleRed3.setWeight(Long.valueOf("10"));
		
		listApple.add(appleBlue);
		listApple.add(appleRed3);
		listApple.add(appleGreen);
		listApple.add(appleRed);
		
		return listApple;
	}
	
	private static List<Apple> getOnlyRedApples(List<Apple> inventory){
		List<Apple> onlyReds = new ArrayList<>();
		for(Apple apple : inventory) {
			if(AppleColor.RED.equals(apple.getColor())) {
				onlyReds.add(apple);
			}
		}
		return onlyReds;
	}
	
	private static List<Apple> getHeavyApples(List<Apple> inventory){
		List<Apple> onlyHeavy = new ArrayList<>();
		for(Apple apple: inventory) {
			if(apple.getWeight() > Long.valueOf("15")) {
				onlyHeavy.add(apple);
			}
		}
		return onlyHeavy;
	}

}
