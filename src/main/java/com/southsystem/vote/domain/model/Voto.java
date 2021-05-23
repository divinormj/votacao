package com.southsystem.vote.domain.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Voto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer voto;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pauta pauta;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Associado associado;
	
	public void setVoto(VotoType type) {
		if(Objects.nonNull(type)) {
			voto = type.getId();
		}
	}
}
