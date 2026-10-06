package com.unifacisa.Academia.controller;

import com.unifacisa.Academia.entities.Ficha;
import com.unifacisa.Academia.service.FichaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fichas")
public class FichaController {
    @Autowired
    private FichaService fichaService;

    @PostMapping
    public Ficha cadastrarFicha(@RequestBody Ficha ficha) {
        return fichaService.cadastrarFicha(ficha);
    }

    @GetMapping
    public List<Ficha> listarFicha() {
        return fichaService.listarFicha();
    }

    @DeleteMapping("/{idFicha}")
    public ResponseEntity<Void> deletarFicha(@PathVariable Integer idFicha) {
        fichaService.deletarFicha(idFicha);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{idFicha}")
    public ResponseEntity<Ficha> atualizarFicha(@PathVariable Integer idFicha, @RequestBody Ficha novaFicha) {
        Ficha ficha = fichaService.atualizarFicha(idFicha, novaFicha);
        return ResponseEntity.ok(ficha);
    }

}
