package com.unifacisa.Academia.service;

import com.unifacisa.Academia.entities.Aluno;
import com.unifacisa.Academia.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno cadastrarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarAluno(){
        return alunoRepository.findAll();
    }

    public void deletarAluno(Integer idAluno){
        if(!alunoRepository.existsById(idAluno)){
            throw new RuntimeException("Não existe nenhum aluno com este id");
        }
        alunoRepository.deleteById(idAluno);
    }

    public Aluno atualizarAluno(Integer idAluno, Aluno novoAluno){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(() ->
                new RuntimeException("Não existe nenhum aluno neste id"));

        aluno.setTelefone(novoAluno.getTelefone());
        aluno.setNome(novoAluno.getNome());
        aluno.setEmail(novoAluno.getEmail());
        aluno.setInstrutor(novoAluno.getInstrutor());
        return alunoRepository.save(aluno);

    }
}
