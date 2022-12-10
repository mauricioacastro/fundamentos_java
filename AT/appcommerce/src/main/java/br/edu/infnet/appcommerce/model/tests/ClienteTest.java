package br.edu.infnet.appcommerce.model.tests;

import br.edu.infnet.appcommerce.model.domain.Cliente;
import br.edu.infnet.appcommerce.model.exceptions.ClienteInvalidoException;

public class ClienteTest {

	public static void main(String[] args) {

		try {
			Cliente s1 = new Cliente("huguinho", "12312312312", "hugo@hugo.com");
			System.out.println(s1);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente s2 = new Cliente(null, "12312312312", "ze@ze.com");
			System.out.println(s2);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente s3 = new Cliente("luizinho", null, "luiz@luiz.com");
			System.out.println(s3);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente s3 = new Cliente("luizinho", "12312312312", null);
			System.out.println(s3);
		} catch (ClienteInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}