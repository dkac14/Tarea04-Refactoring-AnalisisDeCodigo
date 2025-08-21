package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioPaseo;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FabricaServicioPaseoTest {

    @Test
    void FP001_createServicio_retornaInstanciaCorrecta() {
        FabricaServicioPaseo fabrica = new FabricaServicioPaseo();

        Servicio servicio = fabrica.createServicio();

        assertNotNull(servicio);
        assertTrue(servicio instanceof ServicioPaseo);
    }

    @Test
    void FP002_createServicio_instanciasIndependientes() {
        FabricaServicioPaseo fabrica = new FabricaServicioPaseo();

        Servicio s1 = fabrica.createServicio();
        Servicio s2 = fabrica.createServicio();

        assertNotSame(s1, s2);
    }

    @Test
    void FP003_createServicio_valoresPorDefecto() {
        FabricaServicioPaseo fabrica = new FabricaServicioPaseo();
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
            salida.contains("Ejecutando servicio de Paseo"),
            "Salida esperada: 'Ejecutando servicio de Paseo'. Fue: " + salida
        );

        
        assertEquals(1.0, servicio.getPrecio(), 1e-9);
    }
}
