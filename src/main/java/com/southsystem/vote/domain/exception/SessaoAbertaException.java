package com.southsystem.vote.domain.exception;

public class SessaoAbertaException extends EntidadeNaoEncontradaException {
	private static final long serialVersionUID = 1L;

	public SessaoAbertaException(String mensagem) {
		super(mensagem);
	}
	
	public SessaoAbertaException(Long pautaId) {
		this(String.format("A sessão de votação ainda está aberta para a pauta com identificador %d", pautaId));
	}
}
