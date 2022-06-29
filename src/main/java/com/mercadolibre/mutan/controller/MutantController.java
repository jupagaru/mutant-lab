package com.mercadolibre.mutan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.mutan.dto.MutantDTO;
import com.mercadolibre.mutan.service.MutantService;

@RestController
@RequestMapping("api/v1/mutants")
public class MutantController {
	
	@Autowired
	MutantService mutantService;
	
	@GetMapping()
	public List<MutantDTO> findAll() throws Exception{
		return null;
	}

}
