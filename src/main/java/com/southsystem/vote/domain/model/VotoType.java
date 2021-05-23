package com.southsystem.vote.domain.model;

import lombok.Getter;

@Getter
public enum VotoType {
	SIM(1, "Sim"),
	NAO(2, "Não");
	
	private Integer id;
	private String descricao;
	
	VotoType(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
}
