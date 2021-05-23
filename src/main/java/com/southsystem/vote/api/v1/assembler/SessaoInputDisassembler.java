package com.southsystem.vote.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.southsystem.vote.api.v1.model.input.SessaoInput;
import com.southsystem.vote.domain.model.Sessao;

@Component
public class SessaoInputDisassembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Sessao toDomainObject(SessaoInput sessaoInput) {
		return modelMapper.map(sessaoInput, Sessao.class);
	}
	
	public void copyToDomainObject(SessaoInput sessaoInput, Sessao sessao) {
		modelMapper.map(sessaoInput, sessao);
	}
}
