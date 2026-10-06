package com.unifacisa.Academia.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "fichas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idFicha;

    private Double peso;
    private Double altura;
    private String objetivo;
    private LocalDateTime dataAvaliacao;

    @OneToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
}
