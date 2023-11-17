package com.gerencial.central155.controllres;

import com.gerencial.central155.dtos.ChamadosRecordDto;
import com.gerencial.central155.dtos.PrestadorRecordDto;
import com.gerencial.central155.entitys.ChamadosEntity;
import com.gerencial.central155.entitys.PrestadorEntity;
import com.gerencial.central155.services.ChamadosServices;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chamados")
public class ChamadosController {

    @Autowired
    ChamadosServices chamadosServices;


    @GetMapping
    public ResponseEntity<List<ChamadosEntity>> getAll () {
        return ResponseEntity.status(HttpStatus.OK).body(chamadosServices.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById (@PathVariable(value = "id") Long id){
        Optional<ChamadosEntity> getChamado = chamadosServices.findById(id);
        if (getChamado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("register not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(chamadosServices.findById(id));

    }

    @PostMapping
    public  ResponseEntity<Object> save (@RequestBody @Valid ChamadosRecordDto dto) {
        if(chamadosServices.existsByProtocolo(dto.protocolo())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um prestador no banco de dados");
        }
        var newChamado = new ChamadosEntity();
        BeanUtils.copyProperties(dto, newChamado);
        return ResponseEntity.status(HttpStatus.CREATED).body(chamadosServices.save(newChamado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update (@PathVariable(value = "id") Long id,
                                          @RequestBody @Valid ChamadosRecordDto dto){
        Optional<ChamadosEntity> getChamado = chamadosServices.findById(id);
        if (getChamado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("register not found.");
        }

        var upadateProtocolo = getChamado.get();
        BeanUtils.copyProperties(dto, upadateProtocolo);
        return ResponseEntity.status(HttpStatus.OK).body(chamadosServices.save(upadateProtocolo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete (@PathVariable(value = "id") Long id){
        Optional<ChamadosEntity> getChamado = chamadosServices.findById(id);
        if (getChamado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("register not found.");
        }
        chamadosServices.delete(getChamado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Record deleted successfully.");

    }


}
