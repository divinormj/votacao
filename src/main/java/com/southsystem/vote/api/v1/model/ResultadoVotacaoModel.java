package com.southsystem.vote.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Representação do recurso ResultadoVotacao para envio aos consumidores da api.
 * @author divino
 *
 */
@Getter
@Setter
public class ResultadoVotacaoModel {

	@ApiModelProperty(example = "10")
	private Integer sim;
	
	@ApiModelProperty(example = "4")
	private Integer nao;
	
	private PautaModel pauta;
	
}
