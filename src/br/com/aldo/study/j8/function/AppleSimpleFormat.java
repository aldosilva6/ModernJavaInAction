package br.com.aldo.study.j8.function;

public class AppleSimpleFormat implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		return "An apple of  " + apple.getWeight() + "g";
	}

}
