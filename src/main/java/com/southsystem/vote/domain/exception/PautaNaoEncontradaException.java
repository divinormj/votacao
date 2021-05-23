package com.southsystem.vote.domain.exception;

public class PautaNaoEncontradaException extends EntidadeNaoEncontradaException {
	private static final long serialVersionUID = 1L;

	public PautaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public PautaNaoEncontradaException(Long pautaId) {
		this(String.format("Não existe um cadastro de pauta com identificador %d", pautaId));
	}
}
