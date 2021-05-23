package com.southsystem.vote.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.southsystem.vote.domain.model.Pauta;
import com.southsystem.vote.util.DatabaseCleaner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
public class PautaServiceTest {
	
	@Autowired
	private DatabaseCleaner databaseCleaner;
	
	@Autowired
	private PautaService pautaService;
	
	@Before
	public void setUp() {
		databaseCleaner.clearTables();
	}
	
	@Test
	public void shouldBeAbleToSuccessfullyRecordNewPauta() {
		Pauta pauta = new Pauta();
		pauta.setDescricao("Criar nova pauta teste service");
		
		pauta = pautaService.save(pauta);
		
		assertThat(pauta).isNotNull();
		assertThat(pauta.getId()).isNotNull();
	}
	
	@Test(expected = DataIntegrityViolationException.class)
	public void shouldNotBeAbleToRecordNewPautaWhenDescriptionIsEmpty() {
		Pauta pauta = new Pauta();
		
		pautaService.save(pauta);
	}

}
