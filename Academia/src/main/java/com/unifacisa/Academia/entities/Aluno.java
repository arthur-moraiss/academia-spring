package com.unifacisa.Academia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="alunos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAluno;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    private String email;

    @ManyToOne
    @JoinColumn(name ="instrutor_id")
    private Instrutor instrutor;

    @ManyToMany(mappedBy = "alunos")
    private List<Treino> treinos = new ArrayList<>();

}
