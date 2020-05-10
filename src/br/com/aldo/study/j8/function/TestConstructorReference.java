package br.com.aldo.study.j8.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TestConstructorReference {
	
	static Map<String, Function<Long, Fruit>> map = new HashMap<>();
	static {
		map.put("apple", Apple::new);
		//The same thing with lambda expression
		map.put("orange", (Long weight) -> new Orange(weight));
	}
	
	
	public static void main(String[] args) {
		Fruit apple = giveMeFruit("apple", Long.valueOf("20"));
		
		System.out.println(apple.getWeight());
	}
	
	
	
	public static Fruit giveMeFruit(String fruit, Long weight) {
		return map.get(fruit).apply(weight);
	}

}
