package com.mercadolibre.mutan.mapper;

import org.mapstruct.Mapper;

import com.mercadolibre.mutan.domain.Mutant;
import com.mercadolibre.mutan.dto.MutantDTO;

@Mapper
public interface MutantMapper {
	
	public MutantDTO mutantToMutantDTO(Mutant mutant);

}
