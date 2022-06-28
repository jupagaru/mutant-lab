package com.mercadolibre.mutan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadolibre.mutan.domain.Mutant;

public interface MutantRepository extends JpaRepository<Mutant, Integer>{

	List<Mutant> findByIsMutant(boolean isMutant);
}
