package br.com.aldo.study.j8.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * A Function is a function interface that has a method that receive a object
 * of type T as parameter and return another object of type R as response
 * 
 * @author aldosilva
 *
 */
public class TestFunction {
	
	public static void main(String[] args) {
		List<Integer> listIntegers = transform(Arrays.asList("aldo","maanuu","test"), (String s) -> s.length());
		
		listIntegers.forEach((Integer i) -> System.out.println(i.toString()));
		
		List<Integer> listIntAnonymousClass = transform(Arrays.asList("aldo","maanuu","test"), new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return t.length();
			}
		});
		
		listIntAnonymousClass.forEach(s -> System.out.println(s));
	}
	
	public static <T, R> List<R> transform(List<T> list, Function<T, R> func){
		List<R> result = new ArrayList<>();
		for(T t : list) {
			result.add(func.apply(t));
		}
		
		return result;
	}

}
