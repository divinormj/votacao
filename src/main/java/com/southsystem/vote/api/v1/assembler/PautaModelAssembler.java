package com.southsystem.vote.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.southsystem.vote.api.v1.model.PautaModel;
import com.southsystem.vote.domain.model.Pauta;

@Component
public class PautaModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PautaModel toModel(Pauta pauta) {
		return modelMapper.map(pauta, PautaModel.class);
	}
}
