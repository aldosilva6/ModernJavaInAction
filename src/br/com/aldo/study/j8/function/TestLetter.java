package br.com.aldo.study.j8.function;

import java.util.function.Function;

public class TestLetter {
	
	public static void main(String[] args) {
		Function<String, String> addHeader = Letter::addHeader;
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
		
		System.out.println(transformationPipeline.apply("Mauricio labda"));
	}

}
