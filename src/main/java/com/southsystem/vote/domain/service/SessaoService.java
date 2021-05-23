package com.southsystem.vote.domain.service;

import java.time.OffsetDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.southsystem.vote.domain.exception.SessaoAbertaException;
import com.southsystem.vote.domain.exception.SessaoEncerradaException;
import com.southsystem.vote.domain.exception.SessaoJaCadastradaException;
import com.southsystem.vote.domain.exception.SessaoNaoEncontradaException;
import com.southsystem.vote.domain.model.Pauta;
import com.southsystem.vote.domain.model.Sessao;
import com.southsystem.vote.domain.repository.SessaoRepository;

@Service
public class SessaoService {
	
	private final static Integer TEMPO_VOTACAO_PADRAO = 1;

	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Autowired
	private PautaService pautaService;
	
	@Transactional
	public Sessao save(Sessao sessao) {
		this.validaDadosSessao(sessao);		
		return sessaoRepository.save(sessao);
	}
	
	private void validaDadosSessao(Sessao sessao) {
		final var existeSessao = sessaoRepository.findByPauta(sessao.getPauta());
		final var pautaId = sessao.getPauta().getId();
		if(Objects.nonNull(existeSessao)) {
			throw new SessaoJaCadastradaException(pautaId);
		}
		
		if(Objects.isNull(sessao.getTempoVotacao())) {
			sessao.setTempoVotacao(TEMPO_VOTACAO_PADRAO);
		}
		
		Pauta pauta = pautaService.buscarOuFalhar(pautaId);
		sessao.setPauta(pauta);		
	}
	
	public Sessao buscarSessaoAberta(Long pautaId) {
		final var pauta = new Pauta();
		pauta.setId(pautaId);
		final var sessao = sessaoRepository.findByPauta(pauta);
		if(Objects.isNull(sessao)) {
			throw new SessaoNaoEncontradaException(pautaId);
		}
		
		if(OffsetDateTime.now().isAfter(sessao.retrieveDataEncerramento())) {
			throw new SessaoEncerradaException(pautaId);
		}
		
		return sessao;
	}
	
	public Sessao buscarSessaoEncerrada(Long pautaId) {
		final var pauta = new Pauta();
		pauta.setId(pautaId);
		final var sessao = sessaoRepository.findByPauta(pauta);
		if(Objects.isNull(sessao)) {
			throw new SessaoNaoEncontradaException(pautaId);
		}
		
		if(OffsetDateTime.now().isBefore(sessao.retrieveDataEncerramento())) {
			throw new SessaoAbertaException(pautaId);
		}
		
		return sessao;
	}
}
