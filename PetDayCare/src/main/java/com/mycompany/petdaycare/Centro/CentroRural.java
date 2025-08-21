package com.mycompany.petdaycare.Centro;

public class CentroRural implements Centro{

    private String descripcion="Centro dedicado al cuidado de animales del área rural";

    @Override
    public String getDescripcion() {
        return descripcion;
    }

}
