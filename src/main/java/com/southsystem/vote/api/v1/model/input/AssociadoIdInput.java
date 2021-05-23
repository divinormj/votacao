package com.southsystem.vote.api.v1.model.input;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Representação do identificador do recurso Associado para entrada de dados pelos consumidores da api.
 * @author divino
 *
 */
@Getter
@Setter
public class AssociadoIdInput {
	
	@ApiModelProperty(example = "1", required = true)
	@NotNull
	private Long id;
}
