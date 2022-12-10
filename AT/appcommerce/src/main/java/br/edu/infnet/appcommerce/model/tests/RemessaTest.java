package br.edu.infnet.appcommerce.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appcommerce.model.domain.Informatica;
import br.edu.infnet.appcommerce.model.domain.Remessa;
import br.edu.infnet.appcommerce.model.domain.Eletronico;
import br.edu.infnet.appcommerce.model.domain.Cliente;
import br.edu.infnet.appcommerce.model.exceptions.RemessaSemEletronicoException;
import br.edu.infnet.appcommerce.model.exceptions.RemessaSemClienteException;
import br.edu.infnet.appcommerce.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class RemessaTest {

	public static void main(String[] args) {
		List<Eletronico> eletronicosP1 = new ArrayList<Eletronico>();
		List<Eletronico> eletronicosP2 = new ArrayList<Eletronico>();
		List<Eletronico> eletronicosP3 = new ArrayList<Eletronico>();
		List<Eletronico> eletronicosP4 = new ArrayList<Eletronico>();

		try {
			Informatica b1 = new Informatica("b1caf5", "cafezin", 5, "Cooooffeeee");
			b1.setGelada(false);
			b1.setTamanho(500);

			eletronicosP1.add(b1);
			eletronicosP2.add(b1);
			eletronicosP4.add(b1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Informatica b2 = new Informatica("b2cho10", "chopin", 10, "Brahhh");
			b2.setGelada(true);
			b2.setTamanho(300);

			eletronicosP2.add(b2);
			eletronicosP3.add(b2);
			eletronicosP4.add(b2);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Informatica b3 = new Informatica("b3suc8", "Suquin", 8, "Dafruta");
			b3.setGelada(true);
			b3.setTamanho(1000);

			eletronicosP3.add(b3);
			eletronicosP4.add(b3);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Remessa p1 = new Remessa(new Cliente("huguinho", "12312312312", "hugo@hugo.com"), eletronicosP1);
			p1.setDescricao("Primeiro remessa");
			p1.setWeb(false);
			p1.imprimir();
		} catch (ClienteInvalidoException | RemessaSemClienteException | RemessaSemEletronicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Remessa p2 = new Remessa(new Cliente("zezinho", "12312312312", "ze@ze.com"), eletronicosP2);
			p2.setDescricao("Segundo remessa");
			p2.setWeb(true);
			p2.imprimir();
		} catch (ClienteInvalidoException | RemessaSemClienteException | RemessaSemEletronicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Remessa p3 = new Remessa(new Cliente("luizinho", "12312312312", "luiz@luiz.com"), eletronicosP3);
			p3.setDescricao("Terceiro remessa");
			p3.setWeb(true);
			p3.imprimir();
		} catch (ClienteInvalidoException | RemessaSemClienteException | RemessaSemEletronicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Remessa p4 = new Remessa(new Cliente("mariazinha", "12312312312", "maria@maria.com"), eletronicosP4);
			p4.setDescricao("Quarto remessa");
			p4.setWeb(true);
			p4.imprimir();
		} catch (ClienteInvalidoException | RemessaSemClienteException | RemessaSemEletronicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Remessa p5 = new Remessa(null, eletronicosP4);
			p5.setDescricao("Quinto remessa");
			p5.setWeb(true);
			p5.imprimir();
		} catch (RemessaSemClienteException | RemessaSemEletronicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente s6 = new Cliente("mariazinha", "12312312312", "maria@maria.com");
		
			Remessa p6 = new Remessa(s6, null);
			p6.setDescricao("Sexto remessa");
			p6.setWeb(true);
			p6.imprimir();
		} catch (ClienteInvalidoException | RemessaSemClienteException | RemessaSemEletronicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}