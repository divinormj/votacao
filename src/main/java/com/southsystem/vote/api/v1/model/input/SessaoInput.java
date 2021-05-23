package com.southsystem.vote.api.v1.model.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Representação do recurso Sessao para entrada de dados pelos consumidores da api.
 * @author divino
 *
 */
@Getter
@Setter
public class SessaoInput {
	
	@ApiModelProperty(example = "30")
	private Integer tempoVotacao;

	@Valid
	@NotNull
	private PautaIdInput pauta;
}
