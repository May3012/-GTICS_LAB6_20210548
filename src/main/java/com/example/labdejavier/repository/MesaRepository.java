package com.example.labdejavier.repository;

import com.example.labdejavier.entity.Mesa;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MesaRepository {

    @Query(nativeQuery = true, value = "select * from mesas where disponibilidad= ?1")
    List<Mesa> listaMesasDisponibles(int dispo);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "insert into dispositivo(nombre,cantidad,disponibilidad,eliminado) values (?1,?2,?2,0)")
    void agregarDispositivo(String nombre,Integer cantidad);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update dispositivo set nombre=?2,disponibilidad=disponibilidad-(cantidad-?3),cantidad=?3 where id_dispositivo=?1")
    void editarDispositivo(Integer idDispositivo,String nombre,Integer cantidad);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update dispositivo set eliminado=1 where id_dispositivo=?1")
    void eliminarDispositivo(Integer idDispositivo);
}
