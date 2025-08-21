package com.mycompany.petdaycare.Composite;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;

public class ServicioGuarderiaDiurna extends Servicio {

    public ServicioGuarderiaDiurna() {
        this.nombre = "Guardería Diurna";
        this.descripcion = "Cuidado diurno para mascotas.";
        this.categoria = CategoriaCuidado.BASICA;
        this.precio = 10.0;
    }

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando servicio de " + nombre);
    }
}
