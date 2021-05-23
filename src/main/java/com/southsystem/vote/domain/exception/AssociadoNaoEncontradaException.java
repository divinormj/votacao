package com.southsystem.vote.domain.exception;

public class AssociadoNaoEncontradaException extends EntidadeNaoEncontradaException {
	private static final long serialVersionUID = 1L;

	public AssociadoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public AssociadoNaoEncontradaException(Long associadoId) {
		this(String.format("Não existe um cadastro de associado com identificador %d", associadoId));
	}
}
