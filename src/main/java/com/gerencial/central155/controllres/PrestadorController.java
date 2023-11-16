package com.gerencial.central155.controllres;

import com.gerencial.central155.entitys.PrestadorEntity;
import com.gerencial.central155.services.PrestadoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pretadores")
public class PrestadorController {

    @Autowired
    PrestadoresServices prestadoresServices;


    @GetMapping
    public ResponseEntity<List<PrestadorEntity>> getAll () {

        return ResponseEntity.status(HttpStatus.OK).body(prestadoresServices.getAll());

    }

}
