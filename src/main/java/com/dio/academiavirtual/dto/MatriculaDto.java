package com.dio.academiavirtual.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDto {
    private String nomeAluno;
    private LocalDateTime dataDaMatricula;
}
