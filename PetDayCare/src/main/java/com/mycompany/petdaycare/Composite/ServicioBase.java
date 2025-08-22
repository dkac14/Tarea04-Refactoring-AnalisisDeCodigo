package com.mycompany.petdaycare.Composite;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;

public class ServicioBase extends Servicio {
    public ServicioBase(String nombre, String descripcion, CategoriaCuidado categoria, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
    }

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando el servicio: " + nombre);
    }
}
