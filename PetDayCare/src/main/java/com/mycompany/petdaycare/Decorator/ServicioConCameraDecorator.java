package com.mycompany.petdaycare.Decorator;

import com.mycompany.petdaycare.Composite.Servicio;

public class ServicioConCameraDecorator extends ServicioDecorator {
    public ServicioConCameraDecorator(Servicio s) {
        super(s);
    }

    @Override
    public void ejecutar() {
        super.ejecutar();
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() + 30.0;
    }

    @Override
    protected void aplicarDecoracion() {
        System.out.println("+ Configuración de cámara añadida");
    }
}
