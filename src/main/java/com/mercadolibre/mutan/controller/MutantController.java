package com.mercadolibre.mutan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.mutan.domain.Mutant;
import com.mercadolibre.mutan.dto.MutantDTO;
import com.mercadolibre.mutan.mapper.MutantMapper;
import com.mercadolibre.mutan.service.MutantService;

@RestController
@RequestMapping("api/v1/mutants")
public class MutantController {
	
	@Autowired
	MutantService mutantService;
	
	@Autowired
	MutantMapper mutantMapper;
	
	@PostMapping
	public MutantDTO save(@RequestBody MutantDTO mutantDTO) throws Exception{
		Mutant mutant = mutantMapper.mutantDTOToMutant(mutantDTO);
		mutant = mutantService.save(mutant);
		mutantDTO = mutantMapper.mutantToMutantDTO(mutant);
		return mutantDTO;
	}
	
	@GetMapping("/{mutantId}")
	public MutantDTO findById(@PathVariable("mutantId") Integer  mutantId) throws Exception{
		Mutant mutant = (mutantService.findById(mutantId).isPresent()==true) ? mutantService.findById(mutantId).get():null;
		return mutantMapper.mutantToMutantDTO(mutant);
	}
	@GetMapping()
	public List<MutantDTO> findAll() throws Exception{
		
		List<Mutant> mutants = mutantService.findAll();
		List<MutantDTO> mutantDTOs = mutantMapper.mutantListToMutantDTOList(mutants);
		
		return mutantDTOs;
	}

}
