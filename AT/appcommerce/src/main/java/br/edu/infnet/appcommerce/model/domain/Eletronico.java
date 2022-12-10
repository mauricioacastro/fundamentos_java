package br.edu.infnet.appcommerce.model.domain;

import br.edu.infnet.appcommerce.model.exceptions.TamanhoInformaticaInvalidoException;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public abstract class Eletronico {

	private String codigo;
	private String nome;
	private float valor;
	
	public Eletronico(String codigo, String nome, float valor) throws ValorZeradoException {
		
		if(valor == 0) {
			throw new ValorZeradoException("O valor do eletronico está zerado!");
		}
		
		if(valor < 0) {
			throw new ValorZeradoException("O valor do eletronico está negativo!");
		}

		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}
	
	public abstract float calcularValorVenda() throws TamanhoInformaticaInvalidoException;

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(codigo);
		sb.append(";");
		sb.append(nome);
		sb.append(";");
		sb.append(valor);

		return sb.toString();
	}

	public String getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public float getValor() {
		return valor;
	}	
}