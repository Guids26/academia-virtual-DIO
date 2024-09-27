package com.dio.academiavirtual.mapper;

import com.dio.academiavirtual.dto.AlunoDto;
import com.dio.academiavirtual.dto.MatriculaDto;
import com.dio.academiavirtual.model.Aluno;
import com.dio.academiavirtual.model.Matricula;

public class MatriculaMapper {

    public static MatriculaDto toDto(Matricula matricula){
        return matricula != null && matricula.getAluno() != null ? new MatriculaDto(matricula.getAluno().getNome(), matricula.getDataDaMatricula()) : new MatriculaDto();
    }
}
