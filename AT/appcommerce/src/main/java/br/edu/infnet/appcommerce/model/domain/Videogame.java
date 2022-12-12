package br.edu.infnet.appcommerce.model.domain;

import br.edu.infnet.appcommerce.model.exceptions.ArmazenamentoInformaticaInvalidoException;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class Videogame extends Eletronico {
	
	private String marca;
	private String processador;
	private int memoriaram;
	private int armazenamento;
	private boolean leitordisco;

	public Videogame(String codigo, String nome, float valor, String marca, String processador, int memoriaram) throws ValorZeradoException {
		super(codigo, nome, valor);
		this.marca = marca;
		this.processador = processador;
	}


	@Override
	public float calcularValorVenda() throws ArmazenamentoInformaticaInvalidoException {
		
		if(armazenamento < 64) {
			throw new ArmazenamentoInformaticaInvalidoException("O armazenamento do Videogame está inválido!");
		}
		
		return this.getValor() + (leitordisco ? 500 : 0) + armazenamento * 2f;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(leitordisco ? "leitordisco=S" : "leitordisco=N");
		sb.append(";");
		sb.append(armazenamento);
		sb.append(";");
		sb.append(marca);
		sb.append(";");
		sb.append(processador);
		sb.append(";");
		sb.append(memoriaram);

		return sb.toString();
	}

	public boolean isLeitordisco() {
		return leitordisco;
	}

	public void setLeitordisco(boolean leitordisco) {
		this.leitordisco = leitordisco;
	}

	public int getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(int armazenamento) {
		this.armazenamento = armazenamento;
	}

	public String getMarca() {
		return marca;
	}
	public String getProcessador() {
		return marca;
	}
	public String getMemoriaram() {
		return marca;
	}
	public void setMemoriaram(int memoriaram) {
		this.memoriaram = memoriaram;
	}

}

