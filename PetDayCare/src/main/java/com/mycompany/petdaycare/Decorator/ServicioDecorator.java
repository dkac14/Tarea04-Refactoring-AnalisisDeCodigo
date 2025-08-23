package com.mycompany.petdaycare.Decorator;

import java.math.BigDecimal;

import com.mycompany.petdaycare.Composite.Servicio;

public abstract class ServicioDecorator extends Servicio {
    protected Servicio wrappee;

    public ServicioDecorator(Servicio s) {
        this.wrappee = s;
    }

    @Override
    public void ejecutar() {
        wrappee.ejecutar();
        this.aplicarDecoracion();
    }

    @Override
    public BigDecimal getPrecio() {
        return wrappee.getPrecio();
    }
    protected abstract void aplicarDecoracion();
}
