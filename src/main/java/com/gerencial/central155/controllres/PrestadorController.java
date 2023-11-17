package com.gerencial.central155.controllres;

import com.gerencial.central155.dtos.PrestadorRecordDto;
import com.gerencial.central155.entitys.PrestadorEntity;
import com.gerencial.central155.services.PrestadoresServices;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pretadores")
public class PrestadorController {

    @Autowired
    PrestadoresServices prestadoresServices;


    @GetMapping
    public ResponseEntity<List<PrestadorEntity>> getAll () {
        return ResponseEntity.status(HttpStatus.OK).body(prestadoresServices.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById (@PathVariable(value = "id") Long id){
        Optional<PrestadorEntity> getPrestador = prestadoresServices.findById(id);
        if (getPrestador.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("register not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(prestadoresServices.findById(id));

    }

    @PostMapping
    public  ResponseEntity<Object> save (@RequestBody @Valid PrestadorRecordDto dto) {
        if(prestadoresServices.existsByPrestador(dto.prestador())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um prestador no banco de dados");
        }
        var newPrestador = new PrestadorEntity();
        BeanUtils.copyProperties(dto, newPrestador);
        return ResponseEntity.status(HttpStatus.CREATED).body(prestadoresServices.save(newPrestador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update (@PathVariable(value = "id") Long id,
                                          @RequestBody @Valid PrestadorRecordDto dto){
        Optional<PrestadorEntity> getPrestador = prestadoresServices.findById(id);
        if (getPrestador.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("register not found.");
        }
        if(prestadoresServices.existsByPrestador(dto.prestador())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um prestador no banco de dados");
        }
        var upadatePrestador = getPrestador.get();
        BeanUtils.copyProperties(dto, upadatePrestador);
        return ResponseEntity.status(HttpStatus.OK).body(prestadoresServices.save(upadatePrestador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete (@PathVariable(value = "id") Long id){
        Optional<PrestadorEntity> getPrestador = prestadoresServices.findById(id);
        if (getPrestador.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("register not found.");
        }
        prestadoresServices.delete(getPrestador.get());
        return ResponseEntity.status(HttpStatus.OK).body("Record deleted successfully.");

    }


}
