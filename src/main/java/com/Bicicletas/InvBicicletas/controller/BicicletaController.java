package com.Bicicletas.InvBicicletas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Bicicletas.InvBicicletas.Dto.BicicletaDto;
import com.Bicicletas.InvBicicletas.entity.BicicletaEntity;
import com.Bicicletas.InvBicicletas.services.bicietasService;

@RestController
@RequestMapping("/bicicletas")
public class BicicletaController {

    @Autowired
    private bicietasService bicietasService;

    // Endpoint para obtener todas las bicicletas
    @GetMapping
    public ResponseEntity<List<BicicletaDto>> obtenerTodasLasBicicletas() {
        List<BicicletaDto> bicicletas = bicietasService.obtenerBicicleta();
        return ResponseEntity.ok(bicicletas);
    }

    // Endpoint para guardar una nueva bicicleta
    @PostMapping
    public ResponseEntity<BicicletaDto> guardarBicicleta(@RequestBody BicicletaDto bicicletaDto) {
        BicicletaDto bicicletaGuardada = bicietasService.guarBicicleta(bicicletaDto);
        return new ResponseEntity<>(bicicletaGuardada, HttpStatus.CREATED);
    }

    // Endpoint para encontrar una bicicleta por ID
    @GetMapping("/{id}")
    public ResponseEntity<BicicletaDto> encontrarBicicletaPorId(@PathVariable long id) {
        BicicletaDto bicicleta = bicietasService.EncontrarConId(id);
        if (bicicleta != null) {
            return ResponseEntity.ok(bicicleta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para actualizar una bicicleta por ID
    @PutMapping("/{id}")
    public ResponseEntity<BicicletaDto> actualizarBicicleta(@PathVariable long id,
            @RequestBody BicicletaEntity bicicletaEntity) {
        BicicletaDto bicicletaActualizada = bicietasService.ActualizarBicicleta(id, bicicletaEntity);
        if (bicicletaActualizada != null) {
            return ResponseEntity.ok(bicicletaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar una bicicleta por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<BicicletaDto> eliminarBicicleta(@PathVariable long id) {
        BicicletaDto bicicletaEliminada = bicietasService.EliminarBici(id);
        if (bicicletaEliminada != null) {
            return ResponseEntity.ok(bicicletaEliminada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}