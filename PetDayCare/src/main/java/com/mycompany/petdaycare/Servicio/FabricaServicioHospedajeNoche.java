package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;
import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioBase;
import com.mycompany.petdaycare.Composite.TipoServicio;

public class FabricaServicioHospedajeNoche extends FabricaServicio {
    @Override
    public Servicio createServicio() {
        return new ServicioBase(
            TipoServicio.HOSPEDAJE_NOCTURNO.getNombre(),
            TipoServicio.HOSPEDAJE_NOCTURNO.getDescripcion(),
            CategoriaCuidado.BASICA,
            TipoServicio.HOSPEDAJE_NOCTURNO.getPrecio(),
            TipoServicio.HOSPEDAJE_NOCTURNO.getMoneda()
        );
    }
}