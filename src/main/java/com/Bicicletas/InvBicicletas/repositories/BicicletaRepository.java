package com.Bicicletas.InvBicicletas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Bicicletas.InvBicicletas.entity.BicicletaEntity;

@Repository
public interface BicicletaRepository extends JpaRepository<BicicletaEntity, Long> {

}
