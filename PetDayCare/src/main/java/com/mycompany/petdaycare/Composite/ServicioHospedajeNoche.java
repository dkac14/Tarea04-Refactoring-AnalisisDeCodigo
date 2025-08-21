package com.mycompany.petdaycare.Composite;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;

public class ServicioHospedajeNoche extends Servicio {

    public ServicioHospedajeNoche() {
        this.nombre = "Hospedaje Nocturno";
        this.descripcion = "Servicio de hospedaje nocturno para mascotas.";
        this.categoria = CategoriaCuidado.BASICA;
        this.precio = 1.0;
    }

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando servicio de " + nombre);
    }
}

