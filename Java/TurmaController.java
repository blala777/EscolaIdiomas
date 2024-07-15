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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/turma")
@Tag(name = "Turma", description = "Endpoints for managing turmas")
public class TurmaController {

    @Autowired
    private TurmaService service;

    @GetMapping
    @Operation(summary = "Fetch all turmas")
    public List<Turma> procuraTodos() {
        return service.procuraTodos();
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Fetch turma by ID")
    public Turma procuraPorId(@PathVariable Integer id) {
        return service.procuraPorId(id);
    }

    @PostMapping
    @Operation(summary = "Add a new turma")
    public String adicionaTurma(@RequestBody Turma turma) {
        return service.adicionaTurma(turma);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update an existing turma")
    public String editarTurma(@PathVariable Integer id, @RequestBody Turma turma) {
        return service.editarTurma(id, turma);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete a turma by ID")
    public void excluirTurma(@PathVariable Integer id) {
        service.excluirTurma(id);
    }
}