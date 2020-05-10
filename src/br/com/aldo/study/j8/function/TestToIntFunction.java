package br.com.aldo.study.j8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class TestToIntFunction {
	
	public static void main(String[] args) {
		String text = "TextToBeConvertedInInt";
		
		ToIntFunction<String> stringToInt = (s) -> Integer.parseInt(text);
		//or
		ToIntFunction<String> stringToInt2 = Integer::parseInt;
		
		System.out.println(stringToInt);
		System.out.println(stringToInt2);
		
	}

}
