package com.mercadolibre.mutan.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
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
	@Order(1)
	void debeValidarLasDependencias() {
		assertNotNull(mutantRepository);
	}
	
	@Test
	@Order(2)
	void debeCrearRegistroMutant() {
		//Arrange
		Integer mutantId = 1234;
		
		Mutant mutant = new Mutant();
		mutant.setMutantId(mutantId);
		mutant.setAdn("ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG");
		mutant.setIsMutant("S");
		
		//Act
		mutantRepository.save(mutant);
		
		//Assert
		assertNotNull(mutant, "El mutante es nulo, no se pudo grabar");
	}
	
	@Test
	@Order(3)
	void debeModificarRegistroMutant() {
		//Arrange
		Integer mutantId = 1234;
		Mutant mutant = null;
		
		mutant = mutantRepository.findById(mutantId).get();
		System.out.println("encontró mutant "+ mutant.getAdn());
		mutant.setIsMutant("N");
		
		//Act
		mutantRepository.save(mutant);
		
		//Assert
		assertNotNull(mutant, "El mutante es nulo, no se pudo modificar");
	}

}
