package com.example.EscolaIdiomas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EscolaIdiomas.entities.Turma;
import com.example.EscolaIdiomas.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repository;

	public List<Turma> procuraTodos() {
		List<Turma> listaDeTurmas = repository.findAll();
		return listaDeTurmas;
		
	}
	
	public Turma procuraPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public String adicionaTurma (Turma turma) {
		repository.save(turma);
		return "Turma adicionada com sucesso!";
	}
	
	public String editarTurma (Integer id, Turma turma) {
		Turma response = repository.findById(id).get();

		response.setId(turma.getId());
		response.setMateria(turma.getMateria());
		response.setTurno(turma.getTurno());
		response.setSala(turma.getSala());
		
		repository.save(response);
		return "Turma editado com sucesso!";
	}
	
	public void excluirTurma (Integer id) {
		Turma response = repository.findById(id).get();
		repository.delete(response);
	}
}