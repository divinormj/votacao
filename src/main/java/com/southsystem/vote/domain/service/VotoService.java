package com.southsystem.vote.domain.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.southsystem.vote.domain.exception.AssociadoJaVotouException;
import com.southsystem.vote.domain.model.ResultadoVotacao;
import com.southsystem.vote.domain.model.Voto;
import com.southsystem.vote.domain.model.VotoType;
import com.southsystem.vote.domain.repository.VotoRepository;

@Service
public class VotoService {

	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private AssociadoService associadoService;
	
	@Autowired
	private SessaoService sessaoService;
	
	@Transactional
	public Voto save(Voto voto) {
		this.validaVoto(voto);
		return votoRepository.save(voto);
	}
	
	private void validaVoto(Voto voto) {
		final var associado = associadoService.buscarOuFalhar(voto.getAssociado().getId());
		voto.setAssociado(associado);
		
		final var sessao = sessaoService.buscarSessaoAberta(voto.getPauta().getId());
		voto.setPauta(sessao.getPauta());
		
		final var existeVoto = votoRepository.findByAssociadoAndPauta(voto.getAssociado(), voto.getPauta());
		if(Objects.nonNull(existeVoto)) {
			throw new AssociadoJaVotouException(voto.getAssociado().getId(), voto.getPauta().getId());
		}
	}
	
	public ResultadoVotacao contabiliza(Long pautaId) {
		final var sessao = sessaoService.buscarSessaoEncerrada(pautaId);
		final var countSim = votoRepository.countVoto(pautaId, VotoType.SIM.getId());
		final var countNao = votoRepository.countVoto(pautaId, VotoType.NAO.getId());
		return ResultadoVotacao.builder()
				.sim(countSim)
				.nao(countNao)
				.pauta(sessao.getPauta())
				.build();
	}
}
