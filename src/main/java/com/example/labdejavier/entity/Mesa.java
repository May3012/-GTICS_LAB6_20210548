package com.example.labdejavier.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mesas")
public class Mesa {
    @Id
    @Column(name = "id_mesa", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @NotNull
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @NotNull
    @Column(name = "cantidadDisponible", nullable = false)
    private Integer cantidadDisponible;

    @Size(max = 45)
    @NotNull
    @Column(name = "ubicacion", nullable = false, length = 45)
    private String ubicacion;

}