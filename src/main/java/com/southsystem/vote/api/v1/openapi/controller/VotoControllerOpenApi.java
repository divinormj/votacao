package com.southsystem.vote.api.v1.openapi.controller;

import com.southsystem.vote.api.v1.model.ResultadoVotacaoModel;
import com.southsystem.vote.api.v1.model.input.VotoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Interface para documentação no padrão OpenApi para o recurso Voto
 * @author divino
 *
 */
@Api(tags = "Votação")
public interface VotoControllerOpenApi {

	@ApiOperation("Registra o voto do associado na pauta")
	public void create(@ApiParam(name = "corpo", value = "Representação do voto do associado na pauta") VotoInput votoInput);
	
	@ApiOperation("Retorna o resultado da votação da pauta")
	public ResultadoVotacaoModel contabilizar(@ApiParam(value = "ID da pauta", example = "1") Long pautaId);
}
