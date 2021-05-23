package com.southsystem.vote.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.southsystem.vote.domain.model.Associado;
import com.southsystem.vote.domain.model.Pauta;
import com.southsystem.vote.domain.model.Voto;

@Repository
public interface VotoRepository extends CustomJpaRepository<Voto, Long>{

	@Query("select count(*) from Voto where pauta.id = :pautaId and voto = :votoType")
	Integer countVoto(@Param("pautaId") Long pautaId, @Param("votoType") Integer votoType);
	
	Voto findByAssociadoAndPauta(Associado associado, Pauta pauta);
}
