package com.unifacisa.Academia.controller;

import com.unifacisa.Academia.entities.Aluno;
import com.unifacisa.Academia.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return alunoService.cadastrarAluno(aluno);
    }

    @GetMapping
    public List<Aluno> listarAluno() {
        return alunoService.listarAluno();
    }

    @DeleteMapping("/{idAluno}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Integer idAluno) {
        alunoService.deletarAluno(idAluno);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{idAluno}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Integer idAluno, @RequestBody Aluno novoAluno) {
        Aluno aluno = alunoService.atualizarAluno(idAluno, novoAluno);
        return ResponseEntity.ok(aluno);
    }
}
