package br.edu.infnet.appcommerce.model.tests;

import br.edu.infnet.appcommerce.model.domain.Informatica;
import br.edu.infnet.appcommerce.model.exceptions.TamanhoInformaticaInvalidoException;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class InformaticaTest {

	public static void main(String[] args) {
				
		try {
			Informatica b1 = new Informatica("b1caf5", "cafezin", 5, "Cooooffeeee");
			b1.setGelada(false);
			b1.setTamanho(500);
			System.out.println(b1);
			System.out.println("Valor de Venda = R$" + b1.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Informatica b1 = new Informatica("b1caf5", "cafezin", 5, "Cooooffeeee");
			b1.setGelada(false);
			b1.setTamanho(200);
			System.out.println(b1);
			System.out.println("Valor de Venda = R$" + b1.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Informatica b2 = new Informatica("b2cho10", "chopin", -10, "Brahhh");
			b2.setGelada(true);
			b2.setTamanho(300);
			System.out.println(b2);
			System.out.println("Valor de Venda = R$" + b2.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Informatica b3 = new Informatica("b3suc8", "Suquin", 0, "Dafruta");
			b3.setGelada(true);
			b3.setTamanho(1000);
			System.out.println(b3);
			System.out.println("Valor de Venda = R$" + b3.calcularValorVenda());
		} catch (ValorZeradoException | TamanhoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}