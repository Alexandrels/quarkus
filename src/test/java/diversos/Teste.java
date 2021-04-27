package diversos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Teste {

	public static void main(String[] args) {
		List<String> nomes = new ArrayList<String>();
		nomes.add("Alexandre Silveira");
		nomes.add("Manoel Tur");
		nomes.add("Kiko mia");
		nomes.add("Alexandre Zezo");

		ComparadorPorTamanho comparadorPorTamanho = new ComparadorPorTamanho();

		// forma mais antiga
		/*
		 * nomes.sort(new Comparator<String>() {
		 * 
		 * @Override public int compare(String s1, String s2) { if (s1.length() <
		 * s2.length()) return -1;// vem antes if (s1.length() > s2.length()) return
		 * 1;// vem depois return 0;// empata } });
		 */

		// lambda
		// Integer ja tem um comparador que retorna -1, 0 e 1 para ordenação
		// interface funcional
		nomes.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		nomes.forEach(s -> System.out.println(s));

		// exercicio
		nomes.forEach(new Consumer<String>() {
			@Override
			public void accept(String nome) {
				System.out.println(nome);

			}
		});
		// exercicio com lambda
		nomes.forEach(nome -> System.out.println(nome));

		// exercicio sort
		System.out.println("EXERCICIO 2");
		nomes.sort((String s1, String s2) -> s1.length() - s2.length());
		nomes.forEach(nome -> System.out.println(nome));

		//lambda exercicio 3
		System.out.println("EXERCICIO 3");
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Executando");

			}
		}).start();
		
		new Thread(()->	System.out.println("Executando")).start();
		
		//lambda exercicio 4
		System.out.println("EXERCICIO 4");
		nomes.sort(Comparator.comparing(String::length));
		nomes.forEach(System.out::println);

	}

}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;// vem antes
		if (s1.length() > s2.length())
			return 1;// vem depois
		return 0;// empata
	}

}
