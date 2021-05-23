package com.southsystem.vote.api.v1.model;

import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Representação do recurso Sessao para envio aos consumidores da api.
 * @author divino
 *
 */
@Getter
@Setter
public class SessaoModel {
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "2021-05-22T21:10:31.415Z")
	private OffsetDateTime dataAbertura;
	
	@ApiModelProperty(example = "10")
	private Integer tempoVotacao;
	
	private PautaModel pauta;
}
