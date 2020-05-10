package br.com.aldo.study.j8.function;

import java.util.function.BiFunction;
import java.util.function.Supplier;

import br.com.aldo.study.enums.AppleColor;

public class TestSupplier {
	
	public static void main(String[] args) {
		//First form
		Supplier<String> s = String::new;
		String newStringUsingSupply = s.get();
		
		//Second form
		Supplier<String> s2 = () -> new String();
		String newStringUsingSupply2 = s2.get();
		
		//Calls the default constructor without argument
		Supplier<Apple> newApple = Apple::new;
		Apple a = newApple.get();
		
		//Theird form - Apple expect a AppleColor and Long in constructor, so Supplier cannot create
		BiFunction<AppleColor, Long, Apple> biFunction = Apple::new;
		Apple apple = biFunction.apply(AppleColor.GREEN, Long.valueOf(10));
	}

}
