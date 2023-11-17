package com.gerencial.central155.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_PRESTADORES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestador")
    private Long id;

    @Column(length = 20,  nullable = false)
    private String prestador;

    @OneToMany(mappedBy = "prestador", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Set<ChamadosEntity> chamados;

}
