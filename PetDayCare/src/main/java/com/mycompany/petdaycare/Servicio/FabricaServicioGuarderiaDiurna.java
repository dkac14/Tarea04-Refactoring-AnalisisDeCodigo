package com.mycompany.petdaycare.Servicio;
import com.mycompany.petdaycare.Composite.*;
import com.mycompany.petdaycare.Composite.ServicioGuarderiaDiurna;

public class FabricaServicioGuarderiaDiurna extends FabricaServicio {
    @Override
    public Servicio createServicio() {
        return new ServicioGuarderiaDiurna();
    }
}
