package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioGuarderiaDiurna;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FabricaServicioGuarderiaDiurnaTest {

    
    @Test
    void FG001_createServicio_retornaInstanciaCorrecta() {
        FabricaServicioGuarderiaDiurna fabrica = new FabricaServicioGuarderiaDiurna();

        Servicio servicio = fabrica.createServicio();

        assertNotNull(servicio);
        assertTrue(servicio instanceof ServicioGuarderiaDiurna);
    }

    @Test
    void FG002_createServicio_instanciasIndependientes() {
        FabricaServicioGuarderiaDiurna fabrica = new FabricaServicioGuarderiaDiurna();

        Servicio s1 = fabrica.createServicio();
        Servicio s2 = fabrica.createServicio();

        assertNotSame(s1, s2);
    }

    @Test
    void FG003_createServicio_valoresPorDefecto() {
        FabricaServicioGuarderiaDiurna fabrica = new FabricaServicioGuarderiaDiurna();
        Servicio servicio = fabrica.createServicio();

        // Verifica que ejecutar imprima el nombre esperado
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
            salida.contains("Ejecutando servicio de Guardería Diurna"),
            "Salida esperada: 'Ejecutando servicio de Guardería Diurna'. Fue: " + salida
        );

        // Verifica precio por defecto (según constructor de ServicioGuarderiaDiurna)
        assertEquals(10.0, servicio.getPrecio(), 1e-9);
    }
}
