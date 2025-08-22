package com.mycompany.petdaycare.Observer;

public class UsuarioCliente  {
    private String nombre;

    public UsuarioCliente(String nombre) {
        this.nombre = nombre;
    }
    
    public void update(String context) {
        System.out.println(nombre + " ha recibido una actualización: " + context);
    }
}
