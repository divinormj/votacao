package com.southsystem.vote.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.southsystem.vote.api.v1.model.ResultadoVotacaoModel;
import com.southsystem.vote.domain.model.ResultadoVotacao;

@Component
public class ResultadoVotacaoModelAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResultadoVotacaoModel toModel(ResultadoVotacao resultado) {
		return modelMapper.map(resultado, ResultadoVotacaoModel.class);
	}
}
