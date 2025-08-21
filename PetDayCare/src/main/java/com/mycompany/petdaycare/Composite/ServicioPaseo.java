package com.mycompany.petdaycare.Composite;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;

public class ServicioPaseo extends Servicio {

    public ServicioPaseo() {
        this.nombre = "Paseo";
        this.descripcion = "Paseo de mascotas al aire libre.";
        this.categoria = CategoriaCuidado.BASICA;
        this.precio = 1.0;
    }

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando servicio de " + nombre);
    }
}

