package br.edu.infnet.appcommerce.model.tests;

import br.edu.infnet.appcommerce.model.domain.Informatica;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class EletronicoTest {

	public static void main(String[] args) {
		
		try {
			Informatica i1 = new Informatica("e1Del5", "Dell", 5, "Dell");
			i1.setSsd(false);
			i1.setArmazenamento(500);
			System.out.println(i1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Informatica i2 = new Informatica("e2apr10", "Apple", 10, "Apple");
			i2.setSsd(true);
			i2.setArmazenamento(300);
			System.out.println(i2);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Informatica i3 = new Informatica("e3pec8", "Pecas", 8, "Pecas");
			i3.setSsd(true);
			i3.setArmazenamento(1000);
			System.out.println(i3);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}