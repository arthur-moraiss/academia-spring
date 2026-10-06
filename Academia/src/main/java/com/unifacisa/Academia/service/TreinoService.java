package com.unifacisa.Academia.service;

import com.unifacisa.Academia.entities.Aluno;
import com.unifacisa.Academia.entities.Treino;
import com.unifacisa.Academia.repositories.AlunoRepository;
import com.unifacisa.Academia.repositories.TreinoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {
    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public Treino cadastrarTreino(Treino treino){
        return treinoRepository.save(treino);
    }

    public List<Treino> listarTreino(){
        return treinoRepository.findAll();
    }

    public void deletarTreino(Integer idTreino){
        if(!treinoRepository.existsById(idTreino)){
            throw new RuntimeException("Não existe nenhum treino com este id");
        }
        treinoRepository.deleteById(idTreino);
    }

    public Treino atualizarTreino(Integer idTreino, Treino novoTreino){
        Treino treino = treinoRepository.findById(idTreino).orElseThrow(() ->
                new RuntimeException("Não existe nenhum treino neste id"));

        treino.setNome(novoTreino.getNome());
        treino.setDescricao(novoTreino.getDescricao());
        treino.setGrupoMuscular(novoTreino.getGrupoMuscular());
        treino.setDuracaoMinutos(novoTreino.getDuracaoMinutos());

        return treinoRepository.save(treino);

    }

    @Transactional
    public Treino adicionarAluno(Integer idTreino, Integer idAluno){
        Treino treino = treinoRepository.findById(idTreino).orElseThrow(() ->
                new RuntimeException("Não existe nenhum treino neste id."));
        Aluno aluno= alunoRepository.findById(idAluno).orElseThrow(() ->
                new RuntimeException("Não existe nenhum aluno neste id."));

        if(!treino.getAlunos().contains(aluno)){
            treino.getAlunos().add(aluno);
        }
        return treinoRepository.save(treino);
    }

    @Transactional
    public Treino removerAluno(Integer idTreino,Integer idAluno){
        Treino treino = treinoRepository.findById(idTreino).orElseThrow(() ->
                new RuntimeException("Não existe nenhum treino neste id."));
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(() ->
                new RuntimeException("Não existe nenhum aluno neste id"));

        treino.getAlunos().remove(aluno);
        return treinoRepository.save(treino);
    }
}

