package com.mycompany.petdaycare.Centro;

public class CentroAtencion implements Centro{

    private String descripcion="Centro dedicado a la atención del cliente";

    @Override
    public String getDescripcion() {
        return descripcion;
    }
}
