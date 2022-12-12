package br.edu.infnet.appcommerce.model.domain;

import br.edu.infnet.appcommerce.model.exceptions.ArmazenamentoInformaticaInvalidoException;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class Informatica extends Eletronico {

	private boolean ssd;
	private int armazenamento;
	private String marca;

	public Informatica(String codigo, String nome, float valor, String marca) throws ValorZeradoException {
		super(codigo, nome, valor);
		this.marca = marca;
	}

	@Override
	public float calcularValorVenda() throws ArmazenamentoInformaticaInvalidoException {
		
		if(armazenamento < 120) {
			throw new ArmazenamentoInformaticaInvalidoException("O armazenamento da Informatica está inválido!");
		}
		
		return this.getValor() + (ssd ? 3 : 0) + armazenamento * 0.05f;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(ssd ? "ssd=S" : "ssd=N");
		sb.append(";");
		sb.append(armazenamento);
		sb.append(";");
		sb.append(marca);

		return sb.toString();
	}
	
	public boolean isSsd() {
		return ssd;
	}
	public void setSsd(boolean ssd) {
		this.ssd = ssd;
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
}