package com.example.EscolaIdiomas.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String materia;
	private String turno;
	private String sala;
	
	 @OneToMany(mappedBy = "turma")
	 @JsonManagedReference("turma-aluno")
	    private List<Aluno> aluno;
	
	 @OneToMany(mappedBy = "turma")
	 @JsonManagedReference("turma-professor")
	    private List<Professor> professor;
	
	
	
	public Turma () {}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getMateria() {
		return materia;
	}



	public void setMateria(String materia) {
		this.materia = materia;
	}



	public String getTurno() {
		return turno;
	}



	public void setTurno(String turno) {
		this.turno = turno;
	}



	public String getSala() {
		return sala;
	}



	public void setSala(String sala) {
		this.sala = sala;
	}



	public List<Aluno> getAluno() {
		return aluno;
	}



	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}



	public List<Professor> getProfessor() {
		return professor;
	}



	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
	}



	



	

}
