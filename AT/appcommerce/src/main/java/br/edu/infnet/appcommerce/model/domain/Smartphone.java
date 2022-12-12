package br.edu.infnet.appcommerce.model.domain;

import br.edu.infnet.appcommerce.model.exceptions.ArmazenamentoInformaticaInvalidoException;
import br.edu.infnet.appcommerce.model.exceptions.ValorZeradoException;

public class Smartphone extends Eletronico {

	private String marca;
	private String processador;
	private int memoriaram;
	private int armazenamento;
	private boolean esim;

	public Smartphone(String codigo, String nome, float valor, String marca, String processador, int memoriaram) throws ValorZeradoException {
		super(codigo, nome, valor);
		this.marca = marca;
		this.processador = processador;
	}


	@Override
	public float calcularValorVenda() throws ArmazenamentoInformaticaInvalidoException {
		
		if(armazenamento < 64) {
			throw new ArmazenamentoInformaticaInvalidoException("O armazenamento do Smartphone está inválido!");
		}
		
		return this.getValor() + (esim ? 0 : 120) + armazenamento * 0.5f;
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(esim ? "esim=S" : "esim=N");
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

	public boolean isEsim() {
		return esim;
	}

	public void setEsim(boolean esim) {
		this.esim = esim;
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
		return processador;
	}
	public int getMemoriaram() {
		return memoriaram;
	}
	
	public void setMemoriaram(int memoriaram) {
		this.memoriaram = memoriaram;
	}

}
