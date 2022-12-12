package br.edu.infnet.appcommerce.model.tests;

import br.edu.infnet.appcommerce.model.domain.Videogame;
import br.edu.infnet.appcommerce.model.exceptions.ArmazenamentoInformaticaInvalidoException;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class VideogameTest {

	public static void main(String[] args) {

		try {
			Videogame v1 = new Videogame("v1pla5", "Play 5", 4500, "Sony", "Zen 2", 0);
			v1.setLeitordisco(true);
			v1.setArmazenamento(825);
			v1.setMemoriaram(16);
			System.out.println(v1);
			System.out.println("Valor de Venda = R$" + v1.calcularValorVenda());
		} catch (ValorZeradoException | ArmazenamentoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Videogame v1 = new Videogame("v1pla5", "Play 5", 4500, "Sony", "Zen 2", 0);
			v1.setLeitordisco(false);
			v1.setArmazenamento(0);
			v1.setMemoriaram(16);
			System.out.println(v1);
			System.out.println("Valor de Venda = R$" + v1.calcularValorVenda());
		} catch (ValorZeradoException | ArmazenamentoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Videogame v2 = new Videogame("v2Xbo10", "Xbox Series", 1800, "Microsoft", "Zen 2", 0);
			v2.setLeitordisco(false);
			v2.setArmazenamento(1024);
			v2.setMemoriaram(16);
			System.out.println(v2);
			System.out.println("Valor de Venda = R$" + v2.calcularValorVenda());
		} catch (ValorZeradoException | ArmazenamentoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}

		try {
			Videogame v3 = new Videogame("v3swi8", "Switch", 800, "Nintendo", "NVIDIA Tegra", 0);
			v3.setLeitordisco(false);
			v3.setArmazenamento(64);
			v3.setMemoriaram(4);
			System.out.println(v3);
			System.out.println("Valor de Venda = R$" + v3.calcularValorVenda());
		} catch (ValorZeradoException | ArmazenamentoInformaticaInvalidoException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}
}