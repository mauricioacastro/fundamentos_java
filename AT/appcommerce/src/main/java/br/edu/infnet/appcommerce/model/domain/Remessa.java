package br.edu.infnet.appcommerce.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.infnet.appcommerce.model.exceptions.RemessaSemEletronicoException;
import br.edu.infnet.appcommerce.model.exceptions.RemessaSemClienteException;

public class Remessa {

	private String descricao;
	private boolean web;
	private LocalDateTime data;
	private Cliente cliente;
	private List<Eletronico> eletronicos;
	
	public Remessa(Cliente cliente, List<Eletronico> eletronicos) throws RemessaSemClienteException, RemessaSemEletronicoException {
		
		if(cliente == null) {
			throw new RemessaSemClienteException("Não existe nenhum cliente associado ao remessa!");
		}
		
		if(eletronicos == null) {
			throw new RemessaSemEletronicoException("Não existe nenhum eletronico associado ao remessa!");
		}

		this.cliente = cliente;
		this.eletronicos = eletronicos;
		
		data = LocalDateTime.now();
	}
	
	public void imprimir(){
		System.out.println("Remessa: " + this);
		System.out.println("Cliente: " + cliente);
		System.out.println("Qtde Eletronicos: " + eletronicos.size());
		System.out.println("Eletronicos:");
		for(Eletronico p : eletronicos) {
			System.out.println("- " + p.getNome());
		}
	}
	
	public String obterLinha() {	
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return this.getData().format(formato)+";"+
			   this.getDescricao()+";"+
			   this.getCliente()+";"+
			   this.getEletronicos().size()+"\r\n";
	}
	
	
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return  String.format("%s;%s;%s", 
				descricao, 
				web ? "web" : "loja",  
				data.format(formato)
			);
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isWeb() {
		return web;
	}
	public void setWeb(boolean web) {
		this.web = web;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public List<Eletronico> getEletronicos() {
		return eletronicos;
	}
	public LocalDateTime getData() {
		return data;
	}
}