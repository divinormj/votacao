package com.southsystem.vote.domain.exception;

public class SessaoNaoEncontradaException extends EntidadeNaoEncontradaException {
	private static final long serialVersionUID = 1L;

	public SessaoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public SessaoNaoEncontradaException(Long pautaId) {
		this(String.format("Não existe cadastro de sessão para a pauta com identificador %d", pautaId));
	}
}
