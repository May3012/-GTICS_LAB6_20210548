package com.example.labdejavier.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "idusuario", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Size(max = 256)
    @NotNull
    @Column(name = "apellido", nullable = false, length = 256)
    private String apellido;

    @Size(max = 45)
    @NotNull
    @Column(name = "correo", nullable = false, length = 45)
    private String correo;

    @Size(max = 45)
    @NotNull
    @Column(name = "contrasena", nullable = false, length = 45)
    private String contrasena;

    @NotNull
    @Column(name = "activo", nullable = false)
    private Integer activo;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "idRol", nullable = false)
    private Rol idRol;

}