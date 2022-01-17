package com.tomasmartinez.cursobackend.model;

public class User {
    private static Long index = Long.valueOf(0);
    private Long id;
    private String nombre;

    public User() {
        this.id = index++;
    }

    public User(String nombre) {
        this.id = index++;
        this.nombre = nombre;
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
}
