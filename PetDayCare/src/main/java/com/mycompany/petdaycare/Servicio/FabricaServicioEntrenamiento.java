package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioEntrenamiento;

public class FabricaServicioEntrenamiento extends FabricaServicio {
    
    @Override
    public Servicio createServicio() {
        return new ServicioEntrenamiento();
    }
}
