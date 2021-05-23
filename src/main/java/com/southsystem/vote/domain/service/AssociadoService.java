package com.southsystem.vote.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.southsystem.vote.domain.exception.AssociadoNaoEncontradaException;
import com.southsystem.vote.domain.model.Associado;
import com.southsystem.vote.domain.repository.AssociadoRepository;

@Service
public class AssociadoService {

	@Autowired
	private AssociadoRepository associadoRepository;
	
	public Associado buscarOuFalhar(Long associadoId) {
		return associadoRepository.findById(associadoId)
				.orElseThrow(() -> new AssociadoNaoEncontradaException(associadoId));
	}
}
