package com.unifacisa.Academia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "treinos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer IdTreino;

    @Column(nullable = false)
    private String nome;

    private String descricao;
    private String grupoMuscular;
    private Integer duracaoMinutos;

    @ManyToMany
    @JoinTable(
            name = "treino_aluno",
            joinColumns = @JoinColumn(name = "treino_id"),
            inverseJoinColumns =@JoinColumn(name = "aluno_id")
    )
    @JsonIgnore
    private List<Aluno> alunos = new ArrayList<>();
}
