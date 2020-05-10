package br.com.aldo.study.j8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * A Consumer is a function interface that receive a object and return anything,
 * it's a void method.
 * 
 * @author aldosilva
 *
 */
public class TestConsumer {
	
	public static void main(String[] args) {
		forEach(Arrays.asList("aldo","manu","test"), (String s) -> System.out.println(s));
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> consumer) {
		for(T t : list) {
			consumer.accept(t);
		}
	}
}
