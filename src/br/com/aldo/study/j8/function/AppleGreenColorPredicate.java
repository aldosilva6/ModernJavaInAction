package br.com.aldo.study.j8.function;

import br.com.aldo.study.enums.AppleColor;

public class AppleGreenColorPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return apple.getColor().equals(AppleColor.GREEN);
	}

}
