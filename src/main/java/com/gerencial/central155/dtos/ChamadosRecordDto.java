package com.gerencial.central155.dtos;

import com.gerencial.central155.entitys.PrestadorEntity;

import java.time.LocalDateTime;

public record ChamadosRecordDto(
        PrestadorEntity prestador,
        Integer user_cad,
        LocalDateTime datatime,
        LocalDateTime data_finalizado,
        String descricao,
        String protocolo,
        String title,
        String status
) {
}
