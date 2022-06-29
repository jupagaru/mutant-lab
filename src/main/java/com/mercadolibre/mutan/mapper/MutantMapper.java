package com.mercadolibre.mutan.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mercadolibre.mutan.domain.Mutant;
import com.mercadolibre.mutan.dto.MutantDTO;

@Mapper
public interface MutantMapper {
	
	public MutantDTO mutantToMutantDTO(Mutant mutant);
	
	public Mutant mutantDTOToMutant(MutantDTO mutantDTO);
	
	public List<MutantDTO> mutantListToMutantDTOList(List<Mutant> mutants);
	
	public List<Mutant> mutantDTOListToMutantList(List<MutantDTO> mutantDTOs);

}
