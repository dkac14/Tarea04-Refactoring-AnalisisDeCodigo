package com.mycompany.petdaycare.Observer;

public class UsuarioCliente implements Usuario {
    private String nombre;

    public UsuarioCliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update(String context) {
        System.out.println(nombre + " ha recibido una actualización: " + context);
    }
}
