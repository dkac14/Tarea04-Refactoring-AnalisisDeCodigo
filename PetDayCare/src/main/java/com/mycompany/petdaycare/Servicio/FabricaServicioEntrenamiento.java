package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;
import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioBase;
import com.mycompany.petdaycare.Composite.TipoServicio;

public class FabricaServicioEntrenamiento extends FabricaServicio {
    
    @Override
    public Servicio createServicio() {
        return new ServicioBase(
            TipoServicio.ENTRENAMIENTO.getNombre(),
            TipoServicio.ENTRENAMIENTO.getDescripcion(),
            CategoriaCuidado.BASICA,
            TipoServicio.ENTRENAMIENTO.getPrecio()
        );
    }
}


