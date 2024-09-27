package com.dio.academiavirtual.mapper;

import com.dio.academiavirtual.dto.AvaliacaoFisicaDto;
import com.dio.academiavirtual.dto.MatriculaDto;
import com.dio.academiavirtual.model.AvaliacaoFisica;
import com.dio.academiavirtual.model.Matricula;

public class AvaliacaoFisicaMapper {

    public static AvaliacaoFisicaDto toDto(AvaliacaoFisica avaliacaoFisica){
        return avaliacaoFisica != null && avaliacaoFisica.getAluno() != null ? new AvaliacaoFisicaDto(avaliacaoFisica.getPeso(), avaliacaoFisica.getAltura(), avaliacaoFisica.getDataDaAvaliacao()) : new AvaliacaoFisicaDto();
    }

}
