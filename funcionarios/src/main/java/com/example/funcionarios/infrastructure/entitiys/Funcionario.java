package com.example.funcionarios.infrastructure.entitiys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Funcionario")
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "profissão")
    private String profissao;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "salario")
    private Double salario;
}
