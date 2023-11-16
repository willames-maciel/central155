package com.gerencial.central155.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "TB_PRESTADORES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 20,  nullable = false)
    private String prestador;

}
