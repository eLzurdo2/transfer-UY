package com.example.Transfer_UY.Demo_1V.models;

import jakarta.persistence.*;

@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido; // Nuevo campo para el apellido
    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    public Jugador() {}

    public Jugador(String nombre, String apellido, Integer edad, Equipo equipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.equipo = equipo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}


