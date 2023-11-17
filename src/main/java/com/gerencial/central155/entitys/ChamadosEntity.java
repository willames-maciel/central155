package com.gerencial.central155.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CHAMADOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChamadosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chamados")
    private Long id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "prestador", referencedColumnName = "id_prestador", nullable = true)
    private PrestadorEntity prestador;

    private Integer user_cad;
    private String status;

    private LocalDateTime datatime;
    private LocalDateTime data_finalizado;
    private String descricao;
    private String protocolo;
    private String title;

}
