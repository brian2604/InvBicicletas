// BicicletaDto.java
package com.Bicicletas.InvBicicletas.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BicicletaDto {
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
