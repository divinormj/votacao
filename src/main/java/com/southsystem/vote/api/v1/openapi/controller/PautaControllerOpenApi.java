package com.southsystem.vote.api.v1.openapi.controller;

import com.southsystem.vote.api.v1.model.PautaModel;
import com.southsystem.vote.api.v1.model.input.PautaInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Interface para documentação no padrão OpenApi para o recurso Pauta
 * @author divino
 *
 */
@Api(tags = "Pautas")
public interface PautaControllerOpenApi {

	@ApiOperation("Cadastra uma pauta")
	public PautaModel create(
			@ApiParam(name = "corpo", value = "Representação de uma nova pauta")
			PautaInput pautaInput);
}
