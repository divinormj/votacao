package com.southsystem.vote.api.v1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.southsystem.vote.api.v1.assembler.ResultadoVotacaoModelAssembler;
import com.southsystem.vote.api.v1.assembler.VotoInputDisassembler;
import com.southsystem.vote.api.v1.model.ResultadoVotacaoModel;
import com.southsystem.vote.api.v1.model.input.VotoInput;
import com.southsystem.vote.api.v1.openapi.controller.VotoControllerOpenApi;
import com.southsystem.vote.domain.model.ResultadoVotacao;
import com.southsystem.vote.domain.model.Voto;
import com.southsystem.vote.domain.service.VotoService;

/**
 * Responsável pelo recurso de Voto do Associado em determinada Pauta.
 * @author divino
 *
 */
@RestController
@RequestMapping(value = "/v1/votos", produces = MediaType.APPLICATION_JSON_VALUE)
public class VotoController implements VotoControllerOpenApi {

	@Autowired
	private VotoService votoService;
	
	@Autowired
	private ResultadoVotacaoModelAssembler resultadoVotacaoModelAssembler;
	
	@Autowired
	private VotoInputDisassembler votoInputDisassembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid VotoInput votoInput) {
		Voto voto = votoInputDisassembler.toDomainObject(votoInput);
		votoService.save(voto);
	}
	
	@GetMapping("/{pautaId}")
	public ResultadoVotacaoModel contabilizar(@PathVariable Long pautaId) {
		ResultadoVotacao resultado = votoService.contabiliza(pautaId);
		return resultadoVotacaoModelAssembler.toModel(resultado);
	}
}
