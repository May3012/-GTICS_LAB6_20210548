package com.example.labdejavier.repository;

import com.example.labdejavier.entity.Mesa;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MesaRepository {

    @Query(nativeQuery = true, value = "select * from mesas where disponibilidad= ?1")
    List<Mesa> listaMesasDisponibles(int dispo);
}
