package com.gerencial.central155.services;

import com.gerencial.central155.entitys.ChamadosEntity;
import com.gerencial.central155.entitys.PrestadorEntity;
import com.gerencial.central155.repositories.ChamadosRepositores;
import com.gerencial.central155.repositories.PrestadoresRepositores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadosServices {

    @Autowired
    ChamadosRepositores chamadosRepositores;


    public List<ChamadosEntity> getAll() {
        return  chamadosRepositores.findAll();

    }

    public ChamadosEntity save(ChamadosEntity newChamado) {
        return chamadosRepositores.save(newChamado);
    }

    public boolean existsByProtocolo(String protocolo) {
        return  chamadosRepositores.existsByProtocolo(protocolo);
    }

    public Optional<ChamadosEntity> findById(Long id) {
        return chamadosRepositores.findById(id);
    }

    public void delete(ChamadosEntity chamado) {
        chamadosRepositores.delete(chamado);
    }


}
