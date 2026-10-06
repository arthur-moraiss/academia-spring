package com.unifacisa.Academia.controller;


import com.unifacisa.Academia.entities.Instrutor;
import com.unifacisa.Academia.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @PostMapping
    public Instrutor cadastrarFicha(@RequestBody Instrutor instrutor) {
        return instrutorService.cadastrarInstrutor(instrutor);
    }

    @GetMapping
    public List<Instrutor> listarInstrutor() {
        return instrutorService.listarInstrutor();
    }

    @DeleteMapping("/{idInstrutor}")
    public ResponseEntity<Void> deletarInstrutor(@PathVariable Integer idInstrutor) {
        instrutorService.deletarInstrutor(idInstrutor);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{idInstrutor}")
    public ResponseEntity<Instrutor> atualizarFicha(@PathVariable Integer idInstrutor, @RequestBody Instrutor novoInstrutor) {
        Instrutor instrutor = instrutorService.atualizarInstrutor(idInstrutor, novoInstrutor);
        return ResponseEntity.ok(instrutor);
    }
}
