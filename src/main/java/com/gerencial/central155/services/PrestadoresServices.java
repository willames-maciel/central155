package com.gerencial.central155.services;

import com.gerencial.central155.entitys.PrestadorEntity;
import com.gerencial.central155.repositories.PrestadoresRepositores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestadoresServices {

    @Autowired
    PrestadoresRepositores prestadoresRepositores;


    public List<PrestadorEntity> getAll() {
        return  prestadoresRepositores.findAll();

    }

    public PrestadorEntity save(PrestadorEntity newPrestador) {
        return prestadoresRepositores.save(newPrestador);
    }

    public boolean existsByPrestador(String prestador) {
        return  prestadoresRepositores.existsByPrestador(prestador);
    }

    public Optional<PrestadorEntity> findById(Long id) {
        return prestadoresRepositores.findById(id);
    }

    public void delete(PrestadorEntity prestadorEntity) {
        prestadoresRepositores.delete(prestadorEntity);
    }
}
