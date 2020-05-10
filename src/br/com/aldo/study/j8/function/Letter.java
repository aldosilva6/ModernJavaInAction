package br.com.aldo.study.j8.function;

public class Letter {
	
	public static String addHeader(String text) {
		return "From Aldo e Manu: " + text;
	}
	
	public static String addFooter(String text) {
		return text + " Kind Regards ";
	}
	
	public static String checkSpelling(String text) {
		return text.replaceAll("labda", "lambda");
	}

}
