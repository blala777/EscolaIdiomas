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

import com.example.EscolaIdiomas.entities.Turma;
import com.example.EscolaIdiomas.services.TurmaService;

@RestController
@RequestMapping(value = "/turma")
public class TurmaController {
	
	@Autowired
	private TurmaService service;
	
	@GetMapping
	 public List<Turma> procuraTodos() {
		   List<Turma> listaDeTurma = service.procuraTodos();
		   return listaDeTurma;
	}	
	
	@GetMapping(value = "/{id}")
	public Turma procuraPorId(@PathVariable Integer id) {
		Turma response = service.procuraPorId(id);
		return response;

}
	@PostMapping
	public String adicionaTurma (@RequestBody Turma turma) {
		String response = service.adicionaTurma(turma);
		return response;
}
	@PutMapping(value = "/{id}")
	public String editarTurma (@PathVariable Integer id, @RequestBody Turma turma) {
		String response = service.editarTurma(id, turma);
		return response;
	}
	
	@DeleteMapping(value = "/{id}")
	public void excluirTurma (@PathVariable Integer id) {
		service.excluirTurma(id);
	}
}