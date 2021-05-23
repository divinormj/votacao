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

import com.southsystem.vote.api.v1.assembler.PautaInputDisassembler;
import com.southsystem.vote.api.v1.assembler.PautaModelAssembler;
import com.southsystem.vote.api.v1.model.PautaModel;
import com.southsystem.vote.api.v1.model.input.PautaInput;
import com.southsystem.vote.api.v1.openapi.controller.PautaControllerOpenApi;
import com.southsystem.vote.domain.model.Pauta;
import com.southsystem.vote.domain.service.PautaService;

/**
 * Responsável pelas operações do recurso Pauta 
 * @author divino
 *
 */
@RestController
@RequestMapping(value = "/v1/pautas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PautaController implements PautaControllerOpenApi {

	@Autowired
	private PautaService pautaService;
	
	@Autowired
	private PautaModelAssembler pautaModelAssembler;
	
	@Autowired
	private PautaInputDisassembler pautaInputDisassembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PautaModel create(@RequestBody @Valid PautaInput pautaInput) {
		Pauta pauta = pautaInputDisassembler.toDomainObject(pautaInput);
		pauta = pautaService.save(pauta);
		return pautaModelAssembler.toModel(pauta);
	}
}
