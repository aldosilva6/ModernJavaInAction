package br.com.aldo.study.j8.function;

import java.util.function.Function;

public class TestComposedFunction {
	
	public static void main(String[] args) {
		//Method andThen take the result from one function and pass to another
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.andThen(g);
		
		System.out.println(h.apply(1));
		
		//Method compose do in reverse order what andThen do
		Function<Integer, Integer> y = x -> x + 1;
		Function<Integer, Integer> j = x -> x * 2;
		Function<Integer, Integer> k = y.compose(j);
		
		System.out.println(k.apply(1));
	}

}
