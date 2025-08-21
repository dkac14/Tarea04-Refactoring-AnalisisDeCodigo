package com.mycompany.petdaycare.Composite;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;

public class ServicioEntrenamiento extends Servicio {

    public ServicioEntrenamiento() {
        this.nombre = "Entrenamiento";
        this.descripcion = "Entrenamiento básico para mascotas.";
        this.categoria = CategoriaCuidado.BASICA;
        this.precio = 3.0;
    }

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando servicio de " + nombre);
    }
}
