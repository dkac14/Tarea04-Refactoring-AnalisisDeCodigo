package com.mycompany.petdaycare.Decorator;

import com.mycompany.petdaycare.Composite.Servicio;

public abstract class ServicioDecorator extends Servicio {
    protected Servicio wrappee;

    public ServicioDecorator(Servicio s) {
        this.wrappee = s;
    }

    @Override
    public void ejecutar() {
        wrappee.ejecutar();
    }

    @Override
    public double getPrecio() {
        return wrappee.getPrecio();
    }
}
