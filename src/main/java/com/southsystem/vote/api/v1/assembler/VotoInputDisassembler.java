package com.southsystem.vote.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.southsystem.vote.api.v1.model.input.VotoInput;
import com.southsystem.vote.domain.model.Voto;

@Component
public class VotoInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Voto toDomainObject(VotoInput votoInput) {
		return modelMapper.map(votoInput, Voto.class);
	}
	
	public void copyToDomainObject(VotoInput votoInput, Voto voto) {
		modelMapper.map(votoInput, voto);
	}
}
