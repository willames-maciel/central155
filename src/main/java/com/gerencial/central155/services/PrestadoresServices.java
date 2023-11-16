package com.gerencial.central155.services;

import com.gerencial.central155.entitys.PrestadorEntity;
import com.gerencial.central155.repositories.PrestadoresRepositores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestadoresServices {

    @Autowired
    PrestadoresRepositores prestadoresRepositores;


    public List<PrestadorEntity> getAll() {
        return  prestadoresRepositores.findAll();

    }
}
