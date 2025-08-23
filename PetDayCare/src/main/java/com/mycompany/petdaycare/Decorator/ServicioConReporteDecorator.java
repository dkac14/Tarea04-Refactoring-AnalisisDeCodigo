package com.mycompany.petdaycare.Decorator;

import java.math.BigDecimal;

import com.mycompany.petdaycare.Composite.Servicio;

public class ServicioConReporteDecorator extends ServicioDecorator {

    public ServicioConReporteDecorator(Servicio s) {
        super(s);
        if (s == null) {
            throw new NullPointerException("El servicio no puede ser null");
        }
    }

    @Override
    public void ejecutar() {
        super.ejecutar();
        aplicarDecoracion(); 
    }

    @Override
    public BigDecimal getPrecio() {
        return super.getPrecio().add(new BigDecimal("20.0"));
    }

    @Override
    protected void aplicarDecoracion() {
        System.out.println("+ Reporte generado");
    }
}
