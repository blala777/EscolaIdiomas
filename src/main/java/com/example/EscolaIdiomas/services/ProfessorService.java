package com.example.EscolaIdiomas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EscolaIdiomas.entities.Professor;
import com.example.EscolaIdiomas.repositories.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;

	public List<Professor> procuraTodos() {
		List<Professor> listaDeProfessores = repository.findAll();
		return listaDeProfessores;
}
	public Professor procuraPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public String adicionaProfessor (Professor professor) {
		repository.save(professor);
		return "Professor adicionado com sucesso!";
	}
	
	public String editarProfessor (Integer id, Professor professor) {
		Professor response = repository.findById(id).get();
	
		response.setId(professor.getId());
		response.setNome(professor.getNome());
		response.setNascimento(professor.getNascimento());
		response.setCpf(professor.getCpf());
		response.setTelefone(professor.getTelefone());
		response.setEmail(professor.getEmail());
		
		repository.save(response);
		return "Professor editado com sucesso!";
	}
	
	public void excluirProfessor (Integer id) {
		Professor response = repository.findById(id).get();
		repository.delete(response);
		
	}
}