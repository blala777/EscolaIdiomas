package com.example.EscolaIdiomas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EscolaIdiomas.entities.Aluno;
import com.example.EscolaIdiomas.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;

	public List<Aluno> procuraTodos() {
		List<Aluno> listaDeAlunos = repository.findAll();
		return listaDeAlunos;
		
	}
	
	public Aluno procuraPorId(Integer id) {
		return repository.findById(id).get();
	}
	
	public String adicionaAluno (Aluno aluno) {
		repository.save(aluno);
		return "Aluno adicionado com Sucesso!";
	}
	
	public String editarAluno (Integer id, Aluno aluno) {
		Aluno response = repository.findById(id).get();

		response.setMatricula(aluno.getMatricula());
		response.setNome(aluno.getNome());
		response.setNascimento(aluno.getNascimento());
		response.setTelefone(aluno.getTelefone());
		response.setEmail(aluno.getEmail());
		
		repository.save(response);
		return "Aluno editado com sucesso!";
	
		
	}
	
	public void excluirAluno (Integer id) {
		Aluno response = repository.findById(id).get();
		repository.delete(response);
	}
}