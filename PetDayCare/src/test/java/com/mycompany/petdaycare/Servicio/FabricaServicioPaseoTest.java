package com.mycompany.petdaycare.Servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;
import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioBase;
import com.mycompany.petdaycare.Composite.TipoServicio;

class FabricaServicioPaseoTest {

    @Test
    void FP001_createServicio_retornaInstanciaCorrecta() {
        FabricaServicioPaseo fabrica = new FabricaServicioPaseo();

        Servicio servicio = fabrica.createServicio();

        assertNotNull(servicio, "El servicio no debe ser null");
        assertTrue(servicio instanceof ServicioBase, "Debe ser instancia de ServicioBase");

        assertEquals(TipoServicio.PASEO.getNombre(), servicio.getNombre());
        assertEquals(TipoServicio.PASEO.getDescripcion(), servicio.getDescripcion());
        assertEquals(TipoServicio.PASEO.getPrecio(), servicio.getPrecio());
        assertEquals(TipoServicio.PASEO.getMoneda(), servicio.getCurrency());
        assertEquals(CategoriaCuidado.BASICA, servicio.getCategoria());
    }

    @Test
    void FP002_createServicio_instanciasIndependientes() {
        FabricaServicioPaseo fabrica = new FabricaServicioPaseo();

        Servicio s1 = fabrica.createServicio();
        Servicio s2 = fabrica.createServicio();

        assertNotNull(s1);
        assertNotNull(s2);
        assertNotSame(s1, s2, "Cada invocación debe devolver instancias distintas");

        // Verificar que ambos objetos tengan los mismos valores
        assertEquals(s1.getNombre(), s2.getNombre());
        assertEquals(s1.getDescripcion(), s2.getDescripcion());
        assertEquals(s1.getPrecio(), s2.getPrecio());
        assertEquals(s1.getCurrency(), s2.getCurrency());
        assertEquals(s1.getCategoria(), s2.getCategoria());
    }

}
