package com.gerencial.central155.repositories;

import com.gerencial.central155.entitys.ChamadosEntity;
import com.gerencial.central155.entitys.PrestadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadosRepositores extends JpaRepository<ChamadosEntity, Long> {

    boolean existsByProtocolo(String protocolo);
}
