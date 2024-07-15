package com.example.EscolaIdiomas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EscolaIdiomas.entities.Professor;
import com.example.EscolaIdiomas.services.ProfessorService;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService service;


   @GetMapping
   public List<Professor> procuraTodos() {
	   List<Professor> listaDeProfessor = service.procuraTodos();
	   return listaDeProfessor;
	   
   }
   
	@GetMapping(value = "/{id}")
	public Professor procuraPorId(@PathVariable Integer id) {
		Professor response = service.procuraPorId(id);
		return response;
	}
	
	@PostMapping
	public String adicionaProfessor (@RequestBody Professor professor) {
		String response = service.adicionaProfessor(professor);
		return response;
	}
	
	@PutMapping(value = "/{id}")
	public String editarProfessor (@PathVariable Integer id, @RequestBody Professor professor) {
		String response = service.editarProfessor(id, professor);
		return response;
	}
	
	@DeleteMapping(value = "/{id}")
	public void excluirProfessor (@PathVariable Integer id) {
		service.excluirProfessor(id);
	}
	   
   }

