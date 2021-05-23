package com.southsystem.vote.domain.exception;

public class SessaoEncerradaException extends EntidadeNaoEncontradaException {
	private static final long serialVersionUID = 1L;

	public SessaoEncerradaException(String mensagem) {
		super(mensagem);
	}
	
	public SessaoEncerradaException(Long pautaId) {
		this(String.format("A sessão de votação já está encerrada para a pauta com identificador %d", pautaId));
	}
}
