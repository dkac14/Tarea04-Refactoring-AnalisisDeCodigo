package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioPaseo;

public class FabricaServicioPaseo extends FabricaServicio {
    @Override
    public Servicio createServicio() {
        return new ServicioPaseo();
    }
}
