package br.com.aldo.study.j8.function;

public class AppleFancyFormat implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		String characteristic = apple.getWeight() > Long.valueOf("15") ? "heavy" : "light";
		
		return "A " + characteristic + " " + apple.getColor() + " apple";
	}

}
