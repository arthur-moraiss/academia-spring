package com.unifacisa.Academia.service;

import com.unifacisa.Academia.entities.Ficha;
import com.unifacisa.Academia.repositories.FichaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaService {

    @Autowired
    private FichaRepository fichaRepository;

    public Ficha cadastrarFicha(Ficha ficha){
        return fichaRepository.save(ficha);
    }

    public List<Ficha> listarFicha(){
        return fichaRepository.findAll();
    }

    public void deletarFicha(Integer idFicha){
        if(!fichaRepository.existsById(idFicha)){
            throw new RuntimeException("Não existe nenhuma ficha com este id");
        }
        fichaRepository.deleteById(idFicha);
    }

    public Ficha atualizarFicha(Integer idFicha, Ficha novaFicha){
        Ficha ficha = fichaRepository.findById(idFicha).orElseThrow(() ->
                new RuntimeException("Não existe nenhuma ficha neste id"));

        ficha.setPeso(novaFicha.getPeso());
        ficha.setAltura(novaFicha.getAltura());
        ficha.setObjetivo(novaFicha.getObjetivo());
        ficha.setDataAvaliacao(novaFicha.getDataAvaliacao());
        ficha.setAluno(novaFicha.getAluno()); // deve enviar o nome do aluno ao trocar
         return fichaRepository.save(ficha);

    }
}
