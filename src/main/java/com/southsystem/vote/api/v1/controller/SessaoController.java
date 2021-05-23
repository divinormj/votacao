package com.southsystem.vote.api.v1.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.southsystem.vote.api.v1.assembler.SessaoInputDisassembler;
import com.southsystem.vote.api.v1.assembler.SessaoModelAssembler;
import com.southsystem.vote.api.v1.model.SessaoModel;
import com.southsystem.vote.api.v1.model.input.SessaoInput;
import com.southsystem.vote.api.v1.openapi.controller.SessaoControllerOpenApi;
import com.southsystem.vote.domain.model.Sessao;
import com.southsystem.vote.domain.service.SessaoService;

/**
 * Responsável pelas operações do recurso Sessão de votação de uma Pauta. 
 * @author divino
 *
 */
@RestController
@RequestMapping(value = "/v1/sessoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class SessaoController implements SessaoControllerOpenApi {

	@Autowired
	private SessaoService sessaoService;
	
	@Autowired
	private SessaoModelAssembler sessaoModelAssembler;
	
	@Autowired
	private SessaoInputDisassembler sessaoInputDisassembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SessaoModel create(@RequestBody @Valid SessaoInput sessaoInput) {
		Sessao sessao = sessaoInputDisassembler.toDomainObject(sessaoInput);
		sessao = sessaoService.save(sessao);
		return sessaoModelAssembler.toModel(sessao);
	}
}
