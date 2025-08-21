package com.mycompany.petdaycare.Administrador;

import com.mycompany.petdaycare.Composite.Servicio;

public class Administrador {
    private String nombre;

    public Administrador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void cambiarDetallesServicio(Servicio s, String nuevoNombre, String nuevaDescripcion, double nuevoPrecio){
        s.setNombre(nuevoNombre);
        s.setDescripcion(nuevaDescripcion);
        s.setPrecio(nuevoPrecio);
        System.out.println("Detalles del servicio actualizados por " + nombre);
    }
}
