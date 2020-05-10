package br.com.aldo.study.j8.function;

import br.com.aldo.study.enums.AppleColor;

public class Apple implements Fruit{
	
	private AppleColor color;
	
	private Long weight;

	public AppleColor getColor() {
		return color;
	}

	public void setColor(AppleColor color) {
		this.color = color;
	}

	public Apple(Long weight) {
		super();
		this.weight = weight;
	}

	public Apple(AppleColor color, Long weight) {
		super();
		this.color = color;
		this.weight = weight;
	}
	
	public Apple() {
		System.out.println("defaul constructor");
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}
	
	public static boolean isRedApple(Apple apple) {
		return AppleColor.RED.equals(apple.getColor());
	}
	
	public static boolean isHeavy(Apple apple) {
		return apple.getWeight() > Long.valueOf("15");
	}


}
