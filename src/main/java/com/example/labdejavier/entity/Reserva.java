package com.example.labdejavier.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "fechafin", nullable = false, length = 45)
    private String fechafin;

    @Size(max = 45)
    @NotNull
    @Column(name = "fechainicio", nullable = false, length = 45)
    private String fechainicio;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Usuario idCliente;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_mesa", nullable = false)
    private Mesa idMesa;

}