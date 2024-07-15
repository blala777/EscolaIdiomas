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

import com.example.EscolaIdiomas.entities.Aluno;
import com.example.EscolaIdiomas.services.AlunoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/aluno")
@Tag(name = "Aluno", description = "Endpoints for managing alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    @Operation(summary = "Fetch all alunos")
    public List<Aluno> procuraTodos() {
        return service.procuraTodos();
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Fetch aluno by ID")
    public Aluno procuraPorId(@PathVariable Integer id) {
        return service.procuraPorId(id);
    }

    @PostMapping
    @Operation(summary = "Add a new aluno")
    public String adicionaAluno(@RequestBody Aluno aluno) {
        return service.adicionaAluno(aluno);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update an existing aluno")
    public String editarAluno(@PathVariable Integer id, @RequestBody Aluno aluno) {
        return service.editarAluno(id, aluno);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete an aluno by ID")
    public void excluirAluno(@PathVariable Integer id) {
        service.excluirAluno(id);
    }
}