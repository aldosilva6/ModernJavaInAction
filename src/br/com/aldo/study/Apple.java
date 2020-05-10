package br.com.aldo.study;

import br.com.aldo.study.enums.AppleColor;

public class Apple {
	
	private AppleColor color;
	
	private Long weight;

	public AppleColor getColor() {
		return color;
	}

	public void setColor(AppleColor color) {
		this.color = color;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

}
