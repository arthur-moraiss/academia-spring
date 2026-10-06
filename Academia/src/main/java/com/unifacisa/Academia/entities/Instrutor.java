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
@Table(name = "instrutores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idInstrutor;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cref;
    private String especialidade;
    private String telefone;


    @OneToMany(mappedBy = "instrutor")
    @JsonIgnore
    private List<Aluno> alunos = new ArrayList<>();

}
