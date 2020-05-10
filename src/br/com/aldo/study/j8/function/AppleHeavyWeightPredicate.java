package br.com.aldo.study.j8.function;

public class AppleHeavyWeightPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > Long.valueOf("15");
	}

}
