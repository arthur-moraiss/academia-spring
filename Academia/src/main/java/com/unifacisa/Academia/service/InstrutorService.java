package com.unifacisa.Academia.service;

import com.unifacisa.Academia.entities.Instrutor;
import com.unifacisa.Academia.repositories.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public Instrutor cadastrarInstrutor(Instrutor instrutor){
        return instrutorRepository.save(instrutor);
    }

    public List<Instrutor> listarInstrutor(){
        return instrutorRepository.findAll();
    }

    public void deletarInstrutor(Integer idInstrutor){
        if(!instrutorRepository.existsById(idInstrutor)){
            throw new RuntimeException("Não existe nenhum instrutor com este id");
        }
        instrutorRepository.deleteById(idInstrutor);
    }

    public Instrutor atualizarInstrutor(Integer idInstrutor, Instrutor novoInstrutor){
        Instrutor instrutor = instrutorRepository.findById(idInstrutor).orElseThrow(() ->
                new RuntimeException("Não existe nenhum instrutor neste id"));

        instrutor.setAlunos(novoInstrutor.getAlunos());
        instrutor.setCref(novoInstrutor.getCref());
        instrutor.setEspecialidade(novoInstrutor.getEspecialidade());
        instrutor.setNome(novoInstrutor.getNome());
        instrutor.setTelefone(novoInstrutor.getTelefone());

        return instrutorRepository.save(instrutor);

    }
}
