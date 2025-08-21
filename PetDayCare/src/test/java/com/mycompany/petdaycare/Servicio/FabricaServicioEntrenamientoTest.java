package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioEntrenamiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FabricaServicioEntrenamientoTest {

    
    @Test
    void FS001_createServicio_tipoCorrecto() {
        FabricaServicioEntrenamiento fabrica = new FabricaServicioEntrenamiento();

        Servicio s = fabrica.createServicio();

        assertNotNull(s, "El servicio no debe ser null");
        assertTrue(s instanceof ServicioEntrenamiento, "Debe ser instancia de ServicioEntrenamiento");
    }

    
    @Test
    void FS002_createServicio_instanciasIndependientes() {
        FabricaServicioEntrenamiento fabrica = new FabricaServicioEntrenamiento();

        Servicio s1 = fabrica.createServicio();
        Servicio s2 = fabrica.createServicio();

        assertNotNull(s1);
        assertNotNull(s2);
        assertNotSame(s1, s2, "Cada invocación debe devolver una instancia diferente");
        assertTrue(s1 instanceof ServicioEntrenamiento);
        assertTrue(s2 instanceof ServicioEntrenamiento);
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
