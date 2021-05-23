package com.southsystem.vote.api.v1.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Representação do recurso Pauta para entrada de dados pelos consumidores da api. 
 * @author divino
 *
 */
@Getter
@Setter
public class PautaInput {

	@ApiModelProperty(example = "Contratação da South System", required = true)
	@NotBlank
	private String descricao;
}
