// BicicletaEntity.java
package com.Bicicletas.InvBicicletas.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bicicletas")
@Data
public class BicicletaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String modelo;
    private String marca;
    private Double precio;
    private String tipo;
    private String colorPrimario;
    private String colorSecundario;
    private int stock;
    private LocalDateTime fechaR;
}
