package br.com.aldo.study.j8.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate is a function that has a method that always receive 
 * a object and return a boolean
 * 
 * @author aldosilva
 *
 */
public class TestPredicate {
	
	public static void main(String[] args) {
		List<String> listString = Arrays.asList("aldo", "", "manu", "   ","jack");
		
		System.out.println(filterList(listString, (String s) -> !s.isBlank()).toString());
	}
	
	public static <T> List<T> filterList(List<T> list, Predicate<T> p){
		List<T> result = new ArrayList<>();
		for(T t : list) {
			if(p.test(t)) {
				result.add(t);
			}
		}
		return result;
	}

}
