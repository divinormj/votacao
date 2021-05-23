package com.southsystem.vote.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Sessao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private OffsetDateTime dataAbertura;
	
	@Column(nullable = false)
	private Integer tempoVotacao;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Pauta pauta;
	
	@Transient
	public OffsetDateTime retrieveDataEncerramento() {
		return this.getDataAbertura().plusMinutes(this.getTempoVotacao());
	}
}
