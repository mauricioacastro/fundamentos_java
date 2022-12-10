package br.edu.infnet.appcommerce.model.domain;

import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class Smartphone extends Eletronico {

	public Smartphone(String codigo, String nome, float valor) throws ValorZeradoException {
		super(codigo, nome, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float calcularValorVenda() {
		// TODO Auto-generated method stub
		return 0;
	}

}
