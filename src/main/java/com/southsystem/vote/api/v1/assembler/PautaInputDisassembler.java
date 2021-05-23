package com.southsystem.vote.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.southsystem.vote.api.v1.model.input.PautaInput;
import com.southsystem.vote.domain.model.Pauta;

@Component
public class PautaInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Pauta toDomainObject(PautaInput pautaInput) {
		return modelMapper.map(pautaInput, Pauta.class);
	}
	
	public void copyToDomainObject(PautaInput pautaInput, Pauta pauta) {
		modelMapper.map(pautaInput, pauta);
	}
}
