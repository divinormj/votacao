package com.southsystem.vote.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.southsystem.vote.domain.exception.PautaNaoEncontradaException;
import com.southsystem.vote.domain.model.Pauta;
import com.southsystem.vote.domain.repository.PautaRepository;

@Service
public class PautaService {

	@Autowired
	private PautaRepository pautaRepository;
	
	@Transactional
	public Pauta save(Pauta pauta) {
		return pautaRepository.save(pauta);
	}
	
	public Pauta buscarOuFalhar(Long pautaId) {
		return pautaRepository.findById(pautaId)
				.orElseThrow(() -> new PautaNaoEncontradaException(pautaId));
	}
}
