package com.southsystem.vote.api.v1.model.input;

import javax.validation.Valid;

import javax.validation.constraints.NotNull;

import com.southsystem.vote.domain.model.VotoType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 * Representação do recurso Voto para entrada de dados pelos consumidores da api.
 * @author divino
 *
 */
@Getter
@Setter
public class VotoInput {
	
	@ApiModelProperty(example = "Sim", required = true)
	@NotNull
	private VotoType voto;
	
	@Valid
	@NotNull
	private AssociadoIdInput associado;

	@Valid
	@NotNull
	private PautaIdInput pauta;
}
