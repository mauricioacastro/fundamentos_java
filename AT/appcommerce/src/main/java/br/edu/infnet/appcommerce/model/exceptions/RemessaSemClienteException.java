package br.edu.infnet.appcommerce.model.exceptions;

public class RemessaSemClienteException extends Exception {
	private static final long serialVersionUID = 1L;
	public RemessaSemClienteException(String mensagem) {
		super(mensagem);
	}
}
