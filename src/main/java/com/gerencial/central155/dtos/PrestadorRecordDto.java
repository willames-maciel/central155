package com.gerencial.central155.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record PrestadorRecordDto(
        @NotBlank  String prestador) {
}
