package com.mycompany.petdaycare.Servicio;
import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;
import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioBase;
import com.mycompany.petdaycare.Composite.TipoServicio;

public class FabricaServicioGuarderiaDiurna extends FabricaServicio {
    @Override
    public Servicio createServicio() {
        return new ServicioBase(
            TipoServicio.GUARDERIA_DIURNA.getNombre(),
            TipoServicio.GUARDERIA_DIURNA.getDescripcion(),
            CategoriaCuidado.BASICA,
            TipoServicio.GUARDERIA_DIURNA.getPrecio()
        );
    }
}
