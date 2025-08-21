
package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioHospedajeNoche;

public class FabricaServicioHospedajeNoche extends FabricaServicio {
    @Override
    public Servicio createServicio() {
        return new ServicioHospedajeNoche();
    }
}
