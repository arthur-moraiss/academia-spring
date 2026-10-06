package com.unifacisa.Academia.controller;

import com.unifacisa.Academia.entities.Treino;
import com.unifacisa.Academia.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @GetMapping
    public ResponseEntity<List<Treino>> listarTreino() {
        return ResponseEntity.ok(treinoService.listarTreino());
    }

    @PostMapping
    public ResponseEntity<Treino> cadastrarTreino(@RequestBody Treino treino) {
        return ResponseEntity.status(HttpStatus.CREATED).body(treinoService.cadastrarTreino(treino));
    }

    @PutMapping("/{idTreino}")
    public ResponseEntity<Treino> atualizarTreino(@PathVariable Integer idTreino, @RequestBody Treino novoTreino) {
        return ResponseEntity.ok(treinoService.atualizarTreino(idTreino, novoTreino));
    }

    @DeleteMapping("/{idTreino}")
    public ResponseEntity<Void> deletarTreino(@PathVariable Integer idTreino) {
        treinoService.deletarTreino(idTreino);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{idTreino}/alunos/{idAluno}")
    public ResponseEntity<Treino> adicionarAluno(@PathVariable Integer idTreino, @PathVariable Integer idAluno) {
        return ResponseEntity.ok(treinoService.adicionarAluno(idTreino, idAluno));
    }

    @DeleteMapping("/{idTreino}/alunos/{idAluno}")
    public ResponseEntity<Treino> removerAluno(@PathVariable Integer idTreino, @PathVariable Integer idAluno) {
        return ResponseEntity.ok(treinoService.removerAluno(idTreino, idAluno));
    }
}