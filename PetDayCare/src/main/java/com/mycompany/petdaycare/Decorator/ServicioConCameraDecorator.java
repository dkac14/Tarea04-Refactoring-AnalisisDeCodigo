package com.mycompany.petdaycare.Decorator;

import java.math.BigDecimal;
import java.util.Objects;

import com.mycompany.petdaycare.Composite.Servicio;

public class ServicioConCameraDecorator extends ServicioDecorator {

    public ServicioConCameraDecorator(Servicio s) {
        super(Objects.requireNonNull(s, "El servicio no puede ser null"));
    }

    @Override
    public void ejecutar() {
        super.ejecutar();
        aplicarDecoracion(); 
    }

    @Override
    public BigDecimal getPrecio() {
        return super.getPrecio().add(new BigDecimal("30.0"));
    }

    @Override
    protected void aplicarDecoracion() {
        System.out.println("+ Configuración de cámara añadida");
    }
}
