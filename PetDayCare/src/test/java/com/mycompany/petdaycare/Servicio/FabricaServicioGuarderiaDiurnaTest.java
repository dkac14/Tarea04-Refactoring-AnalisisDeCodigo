package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;
import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioBase;
import com.mycompany.petdaycare.Composite.TipoServicio;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FabricaServicioGuarderiaDiurnaTest {

    
    @Test
    void FG001_createServicio_retornaInstanciaCorrecta() {
        FabricaServicioGuarderiaDiurna fabrica = new FabricaServicioGuarderiaDiurna();

        Servicio servicio = fabrica.createServicio();

        assertNotNull(servicio, "El servicio no debe ser null");
        assertTrue(servicio instanceof ServicioBase, "Debe ser instancia de ServicioBase");

        assertEquals(TipoServicio.GUARDERIA_DIURNA.getNombre(), servicio.getNombre());
        assertEquals(TipoServicio.GUARDERIA_DIURNA.getDescripcion(), servicio.getDescripcion());
        assertEquals(TipoServicio.GUARDERIA_DIURNA.getPrecio(), servicio.getPrecio());
        assertEquals(TipoServicio.GUARDERIA_DIURNA.getMoneda(), servicio.getCurrency());
        assertEquals(CategoriaCuidado.BASICA, servicio.getCategoria());
    }

    @Test
    void FG002_createServicio_instanciasIndependientes() {
        FabricaServicioGuarderiaDiurna fabrica = new FabricaServicioGuarderiaDiurna();

        Servicio s1 = fabrica.createServicio();
        Servicio s2 = fabrica.createServicio();

        assertNotNull(s1);
        assertNotNull(s2);
        assertNotSame(s1, s2, "Cada invocación debe devolver instancias diferentes");

        assertEquals(s1.getNombre(), s2.getNombre());
        assertEquals(s1.getDescripcion(), s2.getDescripcion());
        assertEquals(s1.getPrecio(), s2.getPrecio());
        assertEquals(s1.getCurrency(), s2.getCurrency());
        assertEquals(s1.getCategoria(), s2.getCategoria());
    }

    @Test
    void FG003_createServicio_valoresPorDefectoYEjecucion() {
        FabricaServicioGuarderiaDiurna fabrica = new FabricaServicioGuarderiaDiurna();
        Servicio servicio = fabrica.createServicio();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(baos));
        try {
            servicio.ejecutar();
        } finally {
            System.setOut(original);
        }
        String salida = baos.toString().trim();

        assertTrue(
            salida.contains("Ejecutando el servicio: " + TipoServicio.GUARDERIA_DIURNA.getNombre()),
            "Salida esperada que contenga: 'Ejecutando el servicio: Guardería Diurna'. Fue: " + salida
        );

        assertEquals(TipoServicio.GUARDERIA_DIURNA.getPrecio(), servicio.getPrecio());
        assertEquals(TipoServicio.GUARDERIA_DIURNA.getMoneda(), servicio.getCurrency());
    }
}
