package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.KeycloackService;

@RestController
@RequestMapping("/api")
public class AloMundoController {
	
	@Autowired
	private KeycloackService keycloackService;
	
	@GetMapping()
	@PreAuthorize("hasRole('CONSULTAS')")
	public List<Integer> index(){
		Integer[] values = { 1, 3, 7 };		
		return Arrays.asList(values);
	}
	
	@GetMapping("/roles")
	@PreAuthorize("hasRole('INVENTARIO')")
	public List<String> roles(){				
		return keycloackService.getRoles();
	}

}
