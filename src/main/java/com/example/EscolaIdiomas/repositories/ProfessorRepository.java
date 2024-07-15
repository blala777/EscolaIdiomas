package com.example.EscolaIdiomas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EscolaIdiomas.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
	
}
