package com.gerencial.central155.repositories;

import com.gerencial.central155.entitys.PrestadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PrestadoresRepositores extends JpaRepository<PrestadorEntity, Long> {

    boolean existsByPrestador(String prestador);
}
