package br.edu.infnet.appcommerce.model.domain;

import br.edu.infnet.appcommerce.model.exceptions.TamanhoInformaticaInvalidoException;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class Informatica extends Eletronico {

	private boolean gelada;
	private int tamanho;
	private String marca;

	public Informatica(String codigo, String nome, float valor, String marca) throws ValorZeradoException {
		super(codigo, nome, valor);
		this.marca = marca;
	}

	@Override
	public float calcularValorVenda() throws TamanhoInformaticaInvalidoException {
		
		if(tamanho < 300) {
			throw new TamanhoInformaticaInvalidoException("O tamanho da informatica está inválido!");
		}
		
		return this.getValor() + (gelada ? 3 : 0) + tamanho * 0.05f;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(gelada ? "gelada=S" : "gelada=N");
		sb.append(";");
		sb.append(tamanho);
		sb.append(";");
		sb.append(marca);

		return sb.toString();
	}
	
	public boolean isGelada() {
		return gelada;
	}
	public void setGelada(boolean gelada) {
		this.gelada = gelada;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public String getMarca() {
		return marca;
	}
}