package com.mycompany.petdaycare.Decorator;

import com.mycompany.petdaycare.Composite.Servicio;

public class ServicioConReporteDecorator extends ServicioDecorator {
    public ServicioConReporteDecorator(Servicio s) {
        super(s);
    }

    @Override
    public void ejecutar() {
        super.ejecutar();
    }

    @Override
    public double getPrecio() {
        return super.getPrecio() + 20.0;
    }
    @Override
    protected void aplicarDecoracion() {
        System.out.println("+ Reporte generado");
    }
}
