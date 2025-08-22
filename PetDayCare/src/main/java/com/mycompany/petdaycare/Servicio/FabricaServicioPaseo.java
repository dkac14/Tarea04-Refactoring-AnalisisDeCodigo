package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;
import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioBase;
import com.mycompany.petdaycare.Composite.TipoServicio;

public class FabricaServicioPaseo extends FabricaServicio {
    @Override
    public Servicio createServicio() {
        return new ServicioBase(
            TipoServicio.PASEO.getNombre(),
            TipoServicio.PASEO.getDescripcion(),
            CategoriaCuidado.BASICA,
            TipoServicio.PASEO.getPrecio(),
            TipoServicio.PASEO.getMoneda()
        );
    }
}