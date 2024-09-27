package com.dio.academiavirtual.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDto {
    private int id;
    @NotNull(message = "o campo nome é obrigatório")
    private String nome;
    @CPF( message = "CPF informado é inválido")
    private String cpf;
    private String bairro;
    @Past(message = "a data precisa ser anterior a data atual")
    private LocalDate dataDeNascimento;
}
