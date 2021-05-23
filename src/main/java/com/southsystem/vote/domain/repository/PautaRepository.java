package com.southsystem.vote.domain.repository;

import org.springframework.stereotype.Repository;

import com.southsystem.vote.domain.model.Pauta;

@Repository
public interface PautaRepository extends CustomJpaRepository<Pauta, Long>{

}
