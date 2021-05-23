package com.southsystem.vote.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.southsystem.vote.api.v1.model.SessaoModel;
import com.southsystem.vote.domain.model.Sessao;

@Component
public class SessaoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SessaoModel toModel(Sessao sessao) {
		return modelMapper.map(sessao, SessaoModel.class);
	}
}
