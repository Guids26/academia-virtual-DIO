package com.dio.academiavirtual.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaDto {
    @Positive(message = "o peso informado precisar ser positivo")
    private double peso;
    @Positive(message = "a altura informada precisar ser positiva")
    private double altura;
    private LocalDateTime dataDaAvaliacao;
}
