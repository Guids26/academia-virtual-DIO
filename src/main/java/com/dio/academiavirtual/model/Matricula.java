package com.dio.academiavirtual.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "aluno_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Aluno aluno;
    private LocalDateTime dataDaMatricula;
}
