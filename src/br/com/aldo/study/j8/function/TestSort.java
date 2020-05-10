package br.com.aldo.study.j8.function;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import br.com.aldo.study.enums.AppleColor;

public class TestSort {
	
	public static void main(String[] args) {
		List<String> listString = Arrays.asList("aldo", "barbara", "manu", "caio","jack");
		
		listString.forEach(System.out::println);
		
		listString.sort(String::compareTo);
		
		listString.sort(Comparator.comparing(String::toString).reversed());
		
		System.out.println("**************Reversed Order*******************");
		
		listString.forEach(System.out::println);
		
		listString = Arrays.asList("aldo", "barbara", "manu", "caio","jack");
		
		listString.sort((String a1, String a2) -> a1.compareTo(a2));
		
		System.out.println("*************Novo Order********************");
		
		listString.forEach(System.out::println);
		
		
		List<Apple> listApple = getAllApples();
		
		listApple.sort(comparing(Apple::getWeight));
		
		listApple.forEach(s -> System.out.println(s.getWeight()));
	}
	
	private static List<Apple> getAllApples(){
		List<Apple> listApple = new ArrayList<>();
		Apple appleBlue = new Apple(AppleColor.BLUE, Long.valueOf("10"));
		
		Apple appleGreen = new Apple(AppleColor.GREEN, Long.valueOf("20"));
		
		Apple appleRed = new Apple(AppleColor.RED, Long.valueOf("18"));
		
		Apple appleRed3 = new Apple(AppleColor.RED, Long.valueOf("10"));
		
		listApple.add(appleGreen);
		listApple.add(appleBlue);
		listApple.add(appleRed3);	
		listApple.add(appleRed);
		
		return listApple;
	}


}
