package com.mercadolibre.mutan.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.mutan.domain.Mutant;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class MutantRepositoryIT {
	
	@Autowired
	MutantRepository mutantRepository;

	@Test
	void debeValidarLasDependencias() {
		assertNotNull(mutantRepository);
	}
	
	@Test
	void deveCrearRegistroMutant() {
		//Arrange
		Integer mutantId = 1234;
		
		Mutant mutant = new Mutant();
		mutant.setMutantId(mutantId);
		mutant.setAdn("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG");
		mutant.setMutant(true);
		
		//Act
		mutantRepository.save(mutant);
		
		//Assert
		assertNotNull(mutant, "El mutante es nulo, no se pudo grabar");
	}

}
