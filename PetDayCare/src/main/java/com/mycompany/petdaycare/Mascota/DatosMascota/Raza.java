package com.mycompany.petdaycare.Mascota.DatosMascota;

public class Raza {
    private final String nombre;
    private final Especie especie;

    public Raza(String nombre, Especie especie) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("La raza no puede estar vacía");
        }
        this.nombre = nombre;
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public Especie getEspecie() {
        return especie;
    }

    @Override
    public String toString() {
        return nombre + " (" + especie + ")";
    }
}
