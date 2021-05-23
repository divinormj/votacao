package com.southsystem.vote.api.v1.openapi.controller;

import com.southsystem.vote.api.v1.model.SessaoModel;
import com.southsystem.vote.api.v1.model.input.SessaoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Interface para documentação no padrão OpenApi para o recurso Sessao
 * @author divino
 *
 */
@Api(tags = "Sessões")
public interface SessaoControllerOpenApi {

	@ApiOperation("Abre sessão de votação para uma pauta")
	public SessaoModel create(@ApiParam(name = "corpo", value = "Representação de uma nova sessão de votação") SessaoInput sessaoInput);
}
