package com.southsystem.vote.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResultadoVotacao {

	private Integer sim;
	
	private Integer nao;
	
	private Pauta pauta;
}
