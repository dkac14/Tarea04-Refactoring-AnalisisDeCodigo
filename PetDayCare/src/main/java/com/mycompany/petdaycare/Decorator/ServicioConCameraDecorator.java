package com.mycompany.petdaycare.Decorator;

import com.mycompany.petdaycare.Composite.Servicio;

public class ServicioConCameraDecorator extends ServicioDecorator {
    public ServicioConCameraDecorator(Servicio s) {
        super(s);
    }

    @Override
    public void ejecutar() {
        super.ejecutar();
        System.out.println("+ Configuración de cámara añadida");
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() + 30.0;
    }
}
