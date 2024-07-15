package com.example.EscolaIdiomas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EscolaIdiomas.entities.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{

}
