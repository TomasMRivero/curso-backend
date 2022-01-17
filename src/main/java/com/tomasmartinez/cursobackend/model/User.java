package com.tomasmartinez.cursobackend.model;

public class User {
    private static Long index = Long.valueOf(0);
    private Long id;
    private String name;

    public User() {
        this.id = index++;
    }

    public User(String nombre) {
        this.id = index++;
        this.name = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }
}
