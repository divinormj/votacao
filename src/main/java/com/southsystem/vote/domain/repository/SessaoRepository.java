package com.southsystem.vote.domain.repository;

import org.springframework.stereotype.Repository;

import com.southsystem.vote.domain.model.Pauta;
import com.southsystem.vote.domain.model.Sessao;

@Repository
public interface SessaoRepository extends CustomJpaRepository<Sessao, Long>{
	
	Sessao findByPauta(Pauta pauta);
}
