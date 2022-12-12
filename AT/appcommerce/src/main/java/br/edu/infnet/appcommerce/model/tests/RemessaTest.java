package br.edu.infnet.appcommerce.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appcommerce.model.domain.Informatica;
import br.edu.infnet.appcommerce.model.domain.Smartphone;
import br.edu.infnet.appcommerce.model.domain.Videogame;
import br.edu.infnet.appcommerce.model.domain.Remessa;
import br.edu.infnet.appcommerce.model.domain.Eletronico;
import br.edu.infnet.appcommerce.model.domain.Cliente;
import br.edu.infnet.appcommerce.model.exceptions.RemessaSemEletronicoException;
import br.edu.infnet.appcommerce.model.exceptions.RemessaSemClienteException;
import br.edu.infnet.appcommerce.model.exceptions.ClienteInvalidoException;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class RemessaTest {

	public static void main(String[] args) {
		List<Eletronico> eletronicosR1 = new ArrayList<Eletronico>();
		List<Eletronico> eletronicosR2 = new ArrayList<Eletronico>();
		List<Eletronico> eletronicosR3 = new ArrayList<Eletronico>();
		List<Eletronico> eletronicosR4 = new ArrayList<Eletronico>();

		try {
			Informatica i1 = new Informatica("i1Del5", "Inspiron 15", 5, "Dell");
			i1.setSsd(false);
			i1.setArmazenamento(500);

			eletronicosR1.add(i1);
			eletronicosR2.add(i1);
			eletronicosR4.add(i1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Informatica i2 = new Informatica("i2apr10", "Macbook Air", 10, "Apple");
			i2.setSsd(true);
			i2.setArmazenamento(300);

			eletronicosR2.add(i2);
			eletronicosR3.add(i2);
			eletronicosR4.add(i2);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Informatica i3 = new Informatica("i3pec8", "Pecas", 8, "Pecas");
			i3.setSsd(true);
			i3.setArmazenamento(1000);

			eletronicosR3.add(i3);
			eletronicosR4.add(i3);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Smartphone s1 = new Smartphone("s1iph5", "iPhone 14", 5000, "Apple", "A14", 8);
			s1.setEsim(true);
			s1.setArmazenamento(128);

			eletronicosR3.add(s1);
			eletronicosR4.add(s1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Videogame v1 = new Videogame("v1pla5", "Play 5", 4500, "Sony", "Zen 2", 0);
			v1.setLeitordisco(true);
			v1.setArmazenamento(128);
			v1.setMemoriaram(16);

			eletronicosR1.add(v1);
			eletronicosR4.add(v1);
		} catch (ValorZeradoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		try {
			Remessa r1 = new Remessa(new Cliente("maria", "12312312312", "maria@maria.com"), eletronicosR1);
			r1.setDescricao("Primeira remessa");
			r1.setWeb(false);
			r1.imprimir();
		} catch (ClienteInvalidoException | RemessaSemClienteException | RemessaSemEletronicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Remessa r2 = new Remessa(new Cliente("jose", "12312312312", "jose@jose.com"), eletronicosR2);
			r2.setDescricao("Segunda remessa");
			r2.setWeb(true);
			r2.imprimir();
		} catch (ClienteInvalidoException | RemessaSemClienteException | RemessaSemEletronicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Remessa r3 = new Remessa(new Cliente("joao", "12312312312", "joao@joao.com"), eletronicosR3);
			r3.setDescricao("Terceira remessa");
			r3.setWeb(true);
			r3.imprimir();
		} catch (ClienteInvalidoException | RemessaSemClienteException | RemessaSemEletronicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Remessa r4 = new Remessa(new Cliente("roberto", "12312312312", "roberto@roberto.com"), eletronicosR4);
			r4.setDescricao("Quarta remessa");
			r4.setWeb(true);
			r4.imprimir();
		} catch (ClienteInvalidoException | RemessaSemClienteException | RemessaSemEletronicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Remessa r5 = new Remessa(null, eletronicosR4);
			r5.setDescricao("Quinta remessa");
			r5.setWeb(true);
			r5.imprimir();
		} catch (RemessaSemClienteException | RemessaSemEletronicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Cliente c6 = new Cliente("roberto", "12312312312", "roberto@roberto.com");
		
			Remessa r6 = new Remessa(c6, null);
			r6.setDescricao("Sexta remessa");
			r6.setWeb(true);
			r6.imprimir();
		} catch (ClienteInvalidoException | RemessaSemClienteException | RemessaSemEletronicoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}