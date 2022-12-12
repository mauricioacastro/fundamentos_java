package br.edu.infnet.appcommerce.model.tests;

import br.edu.infnet.appcommerce.model.domain.Smartphone;
import br.edu.infnet.appcommerce.model.exceptions.ArmazenamentoInformaticaInvalidoException;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class SmartphoneTest {

	public static void main(String[] args) {
				
		try {
			Smartphone s1 = new Smartphone("s1iph5", "iPhone 14", 5000, "Apple", "A14", 0);
			s1.setEsim(true);
			s1.setArmazenamento(128);
			s1.setMemoriaram(8);
			System.out.println(s1);
			System.out.println("Valor de Venda = R$" + s1.calcularValorVenda());
		} catch (ValorZeradoException | ArmazenamentoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Smartphone s1 = new Smartphone("s1iph5", "iPhone 13", 4500, "Apple", "A13", 0);
			s1.setEsim(false);
			s1.setArmazenamento(60);
			s1.setMemoriaram(6);
			System.out.println(s1);
			System.out.println("Valor de Venda = R$" + s1.calcularValorVenda());
		} catch (ValorZeradoException | ArmazenamentoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Smartphone s2 = new Smartphone("s2and10", "Xiaomi 12", 2100, "Xiaomi", "ARM Cortex", 0);
			s2.setEsim(false);
			s2.setArmazenamento(128);
			s2.setMemoriaram(12);
			System.out.println(s2);
			System.out.println("Valor de Venda = R$" + s2.calcularValorVenda());
		} catch (ValorZeradoException | ArmazenamentoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Smartphone s3 = new Smartphone("s3out8", "Tablet", 1200, "Outros", "DualCore", 0);
			s3.setEsim(true);
			s3.setArmazenamento(1024);
			s3.setMemoriaram(4);
			System.out.println(s3);
			System.out.println("Valor de Venda = R$" + s3.calcularValorVenda());
		} catch (ValorZeradoException | ArmazenamentoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}