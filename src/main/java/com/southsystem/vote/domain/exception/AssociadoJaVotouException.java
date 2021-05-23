package com.southsystem.vote.domain.exception;

public class AssociadoJaVotouException extends EntidadeNaoEncontradaException {
	private static final long serialVersionUID = 1L;

	public AssociadoJaVotouException(String mensagem) {
		super(mensagem);
	}
	
	public AssociadoJaVotouException(Long associadoId, Long pautaId) {
		this(String.format("O associado %d já registrou voto na pauta %d", associadoId, pautaId));
	}
}
