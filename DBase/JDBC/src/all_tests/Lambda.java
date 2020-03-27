package all_tests;

import java.util.LinkedHashMap;

public class Lambda {
	public static void main(String[] args) {
		LinkedHashMap<Integer, Integer> mapa = new LinkedHashMap<>();
		mapa.put(1, 1);
		mapa.put(2, 2);
		mapa.put(3, 3);
		mapa.put(4, 4);
		mapa.put(5, 5);
		String s = ""+mapa.values().stream().reduce(0, (proximo, acumulador)->proximo+acumulador);
		System.out.println(s);
	}
}
