package br.edu.infnet.appcommerce.model.tests;

import br.edu.infnet.appcommerce.model.domain.Informatica;
import br.edu.infnet.appcommerce.model.exceptions.ArmazenamentoInformaticaInvalidoException;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class InformaticaTest {

	public static void main(String[] args) {
				
		try {
			Informatica i1 = new Informatica("i1Del5", "Inspiron", 3000, "Dell");
			i1.setSsd(false);
			i1.setArmazenamento(500);
			System.out.println(i1);
			System.out.println("Valor de Venda = R$" + i1.calcularValorVenda());
		} catch (ValorZeradoException | ArmazenamentoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Informatica i1 = new Informatica("i1Del5", "Inspiron", 3000, "Dell");
			i1.setSsd(false);
			i1.setArmazenamento(60);
			System.out.println(i1);
			System.out.println("Valor de Venda = R$" + i1.calcularValorVenda());
		} catch (ValorZeradoException | ArmazenamentoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Informatica i2 = new Informatica("i2apr10", "Macbook", 10000, "Apple");
			i2.setSsd(true);
			i2.setArmazenamento(120);
			System.out.println(i2);
			System.out.println("Valor de Venda = R$" + i2.calcularValorVenda());
		} catch (ValorZeradoException | ArmazenamentoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Informatica i3 = new Informatica("i3pec8", "Pecas", 500, "Diversas");
			i3.setSsd(true);
			i3.setArmazenamento(1000);
			System.out.println(i3);
			System.out.println("Valor de Venda = R$" + i3.calcularValorVenda());
		} catch (ValorZeradoException | ArmazenamentoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}