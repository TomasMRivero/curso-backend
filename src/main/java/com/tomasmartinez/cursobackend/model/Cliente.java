package com.tomasmartinez.cursobackend.model;

public class Cliente {
    private static Long index = 0L;
    private Long id;
    private String nombre;
    private String apellido;

    public Cliente() {
        this.id = index++;
    }

    public Cliente(String nombre, String apellido) {
        this.id = index++;
        this.nombre = nombre;
        this.apellido = apellido;


    }

    public Long getId() {
        return id;
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
}
