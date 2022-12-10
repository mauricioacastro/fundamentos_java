package br.edu.infnet.appcommerce.model.domain;

import br.edu.infnet.appcommerce.model.exceptions.ClienteInvalidoException;

public class Cliente {

	private String nome;
	private String cpf;
	private String email;

	public Cliente(String nome, String cpf, String email) throws ClienteInvalidoException {
		
		if(nome == null) {
			throw new ClienteInvalidoException("O nome do cliente deve ser preenchido!");
		}
		
		if(cpf == null) {
			throw new ClienteInvalidoException("O CPF do cliente deve ser preenchido!");
		}
		
		if(email == null) {
			throw new ClienteInvalidoException("O e-mail do cliente deve ser preenchido!");
		}
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(cpf);
		sb.append(";");
		sb.append(email);
		
		return sb.toString();
	}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getEmail() {
		return email;
	}
}