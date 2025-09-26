package com.Bicicletas.InvBicicletas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.Bicicletas.InvBicicletas.Dto.BicicletaDto;
import com.Bicicletas.InvBicicletas.entity.BicicletaEntity;
import com.Bicicletas.InvBicicletas.repositories.BicicletaRepository;

@Service
public class bicietasService {
    @Autowired
    private BicicletaRepository bicicletaRepository;

    public List<BicicletaDto> obtenerBicicleta() {
        return bicicletaRepository.findAll()
                .stream()
                .map(bicicleta -> BicicletaDto.builder()
                        .id(bicicleta.getId())
                        .modelo(bicicleta.getModelo())
                        .marca(bicicleta.getMarca())
                        .precio(bicicleta.getPrecio())
                        .tipo(bicicleta.getTipo())
                        .colorPrimario(bicicleta.getColorPrimario())
                        .colorSecundario(bicicleta.getColorSecundario())
                        .stock(bicicleta.getStock())
                        .fechaR(bicicleta.getFechaR())
                        .build())
                .collect(Collectors.toList());
    }

    public BicicletaDto guarBicicleta(BicicletaDto bicicletaDto) {
        BicicletaEntity bicicleta = new BicicletaEntity();
        bicicleta.setId(bicicletaDto.getId());
        bicicleta.setModelo(bicicletaDto.getModelo());
        bicicleta.setMarca(bicicletaDto.getMarca());
        bicicleta.setPrecio(bicicletaDto.getPrecio());
        bicicleta.setTipo(bicicletaDto.getTipo());
        bicicleta.setColorPrimario(bicicletaDto.getColorPrimario());
        bicicleta.setColorSecundario(bicicletaDto.getColorSecundario());
        bicicleta.setStock(bicicletaDto.getStock());
        bicicleta.setFechaR(bicicletaDto.getFechaR());

        BicicletaEntity guardado = bicicletaRepository.save(bicicleta);
        return BicicletaDto.builder()
                .id(guardado.getId())
                .modelo(guardado.getModelo())
                .marca(guardado.getMarca())
                .precio(guardado.getPrecio())
                .tipo(guardado.getTipo())
                .colorPrimario(guardado.getColorPrimario())
                .colorSecundario(guardado.getColorSecundario())
                .stock(guardado.getStock())
                .fechaR(guardado.getFechaR())
                .build();

    }

    public BicicletaDto ActualizarBicicleta(long id, BicicletaEntity bicicletaConNuevosDatos) {
        Optional<BicicletaEntity> bicicletaExistente = bicicletaRepository.findById(id);

        if (bicicletaExistente.isPresent()) {
            BicicletaEntity biciParaActualizar = bicicletaExistente.get();
            // Aqui actualizo los datos de la entidad que ya existe por unos nuevos valores

            biciParaActualizar.setModelo(bicicletaConNuevosDatos.getModelo());
            biciParaActualizar.setMarca(bicicletaConNuevosDatos.getMarca());
            biciParaActualizar.setPrecio(bicicletaConNuevosDatos.getPrecio());
            biciParaActualizar.setTipo(bicicletaConNuevosDatos.getTipo());
            biciParaActualizar.setColorPrimario(bicicletaConNuevosDatos.getColorPrimario());
            biciParaActualizar.setColorSecundario(bicicletaConNuevosDatos.getColorSecundario());
            biciParaActualizar.setStock(bicicletaConNuevosDatos.getStock());
            biciParaActualizar.setFechaR(bicicletaConNuevosDatos.getFechaR());

            // Guardo la entidad en la base de datos con save
            BicicletaEntity biciActualizada = bicicletaRepository.save(biciParaActualizar);

            return BicicletaDto.builder()
                    .id(biciActualizada.getId())
                    .modelo(biciActualizada.getModelo())
                    .marca(biciActualizada.getMarca())
                    .precio(biciActualizada.getPrecio())
                    .tipo(biciActualizada.getTipo())
                    .colorPrimario(biciActualizada.getColorPrimario())
                    .colorSecundario(biciActualizada.getColorSecundario())
                    .stock(biciActualizada.getStock())
                    .fechaR(biciActualizada.getFechaR())
                    .build();
        } else {
            // Devolver null si no se encuentra algun valor
            return null;
        }
    }

    public BicicletaDto EncontrarConId(long id) {
        return bicicletaRepository.findById(id) // llamo la instancia
                .map(bicicleta -> BicicletaDto.builder()
                        .id(bicicleta.getId())
                        .modelo(bicicleta.getModelo())
                        .marca(bicicleta.getMarca())
                        .precio(bicicleta.getPrecio())
                        .tipo(bicicleta.getTipo())
                        .colorPrimario(bicicleta.getColorPrimario())
                        .colorSecundario(bicicleta.getColorSecundario())
                        .stock(bicicleta.getStock())
                        .fechaR(bicicleta.getFechaR())
                        .build())
                .orElse(null);
    }

    public BicicletaDto EliminarBici(long id) {
        Optional<BicicletaEntity> bicicletaEncontrada = bicicletaRepository.findById(id);

        if (bicicletaEncontrada.isPresent()) {
            BicicletaEntity bicicleta = bicicletaEncontrada.get();
            bicicletaRepository.delete(bicicleta);

            // Retorna el DTO de la bicicleta que fue eliminada
            return BicicletaDto.builder()
                    .id(bicicleta.getId())
                    .modelo(bicicleta.getModelo())
                    .marca(bicicleta.getMarca())
                    .precio(bicicleta.getPrecio())
                    .tipo(bicicleta.getTipo())
                    .colorPrimario(bicicleta.getColorPrimario())
                    .colorSecundario(bicicleta.getColorSecundario())
                    .stock(bicicleta.getStock())
                    .fechaR(bicicleta.getFechaR())
                    .build();
        } else {
            // Retorna null si no se encontró la bicicleta
            return null;
        }
    }
}
