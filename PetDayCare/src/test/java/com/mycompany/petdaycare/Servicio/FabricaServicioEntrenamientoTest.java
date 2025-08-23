package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;
import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioBase;
import com.mycompany.petdaycare.Composite.TipoServicio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaServicioEntrenamientoTest {

    
    @Test
    void FS001_createServicio_tipoCorrecto() {
        FabricaServicioEntrenamiento fabrica = new FabricaServicioEntrenamiento();

        Servicio s = fabrica.createServicio();

        assertNotNull(s, "El servicio no debe ser null");
        assertTrue(s instanceof ServicioBase, "Debe ser instancia de ServicioBase");
        assertEquals(TipoServicio.ENTRENAMIENTO.getNombre(), s.getNombre());
        assertEquals(TipoServicio.ENTRENAMIENTO.getDescripcion(), s.getDescripcion());
        assertEquals(TipoServicio.ENTRENAMIENTO.getPrecio(), s.getPrecio());
        assertEquals(TipoServicio.ENTRENAMIENTO.getMoneda(), s.getCurrency());
        assertEquals(CategoriaCuidado.BASICA, s.getCategoria());
    }

    
    @Test
    void FS002_createServicio_instanciasIndependientes() {
        FabricaServicioEntrenamiento fabrica = new FabricaServicioEntrenamiento();

        Servicio s1 = fabrica.createServicio();
        Servicio s2 = fabrica.createServicio();

        assertNotNull(s1);
        assertNotNull(s2);
        assertNotSame(s1, s2, "Cada invocación debe devolver una instancia diferente");
        assertTrue(s1 instanceof ServicioBase);
        assertTrue(s2 instanceof ServicioBase);

        assertEquals(s1.getNombre(), s2.getNombre());
        assertEquals(s1.getDescripcion(), s2.getDescripcion());
        assertEquals(s1.getPrecio(), s2.getPrecio());
        assertEquals(s1.getCurrency(), s2.getCurrency());
    }

    @Test
    void FS003_createServicio_errorDuranteCreacion_sePropagaExcepcion() {
        class FabricaFalla extends FabricaServicioEntrenamiento {
            @Override
            public Servicio createServicio() {
                throw new RuntimeException("Fallo simulado en constructor");
            }
        }

        FabricaServicio fabrica = new FabricaFalla();

        RuntimeException ex = assertThrows(RuntimeException.class, fabrica::createServicio);
        assertTrue(ex.getMessage().contains("Fallo simulado"), "Debe propagar el mensaje de error");
    }
}
