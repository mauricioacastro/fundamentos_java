package br.edu.infnet.appcommerce.model.tests;

import br.edu.infnet.appcommerce.model.domain.Cliente;
import br.edu.infnet.appcommerce.model.exceptions.ClienteInvalidoException;

public class ClienteTest {

	public static void main(String[] args) {

		try {
			Cliente c1 = new Cliente("maria", "12312312312", "maria@maria.com");
			System.out.println(c1);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente c2 = new Cliente(null, "12312312312", "null@null.com");
			System.out.println(c2);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente c3 = new Cliente("jose", null, "jose@jose.com");
			System.out.println(c3);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente c3 = new Cliente("joao", "12312312312", null);
			System.out.println(c3);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}