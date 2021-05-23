package com.southsystem.vote.api.v1.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.southsystem.vote.util.DatabaseCleaner;
import com.southsystem.vote.util.ResourceUtils;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureMockMvc
public class PautaControllerTest {
	
	@Autowired
	private DatabaseCleaner databaseCleaner;
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
		databaseCleaner.clearTables();
	}

	@Test
	public void shouldBeAbleToSuccessfullyRecordNewPautaByAPI() throws Exception {
		final var jsonPautaSuccess = ResourceUtils.getContentFromResource("/json/pauta-success.json");
		mockMvc.perform(
				post("/v1/pautas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonPautaSuccess)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
	}
	
	@Test
	public void shouldNotBeAbleToRecordNewPautaWhenDescriptionIsEmptyByAPI() throws Exception {
		final var jsonPautaSuccess = ResourceUtils.getContentFromResource("/json/pauta-error.json");
		mockMvc.perform(
				post("/v1/pautas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonPautaSuccess)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
	}

}
