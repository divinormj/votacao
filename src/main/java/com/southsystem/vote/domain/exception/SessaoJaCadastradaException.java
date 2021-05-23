package com.southsystem.vote.domain.exception;

public class SessaoJaCadastradaException extends EntidadeNaoEncontradaException {
	private static final long serialVersionUID = 1L;

	public SessaoJaCadastradaException(String mensagem) {
		super(mensagem);
	}
	
	public SessaoJaCadastradaException(Long pautaId) {
		this(String.format("Já existe cadastro de sessão para a pauta com identificador %d", pautaId));
	}
}
