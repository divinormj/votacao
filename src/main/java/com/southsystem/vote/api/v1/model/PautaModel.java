package com.southsystem.vote.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Representação do recurso Pauta para envio aos consumidores da api.
 * @author divino
 *
 */
@Getter
@Setter
public class PautaModel {
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Contratação South System")
	private String descricao;
}
