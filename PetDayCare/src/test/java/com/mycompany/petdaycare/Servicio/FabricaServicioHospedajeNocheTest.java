package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioHospedajeNoche;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FabricaServicioHospedajeNocheTest {

    
    @Test
    void FH001_createServicio_retornaInstanciaCorrecta() {
        FabricaServicioHospedajeNoche fabrica = new FabricaServicioHospedajeNoche();

        Servicio servicio = fabrica.createServicio();

        assertNotNull(servicio);
        assertTrue(servicio instanceof ServicioHospedajeNoche);
    }

    @Test
    void FH002_createServicio_instanciasIndependientes() {
        FabricaServicioHospedajeNoche fabrica = new FabricaServicioHospedajeNoche();

        Servicio s1 = fabrica.createServicio();
        Servicio s2 = fabrica.createServicio();

        assertNotSame(s1, s2);
    }

    @Test
    void FH003_createServicio_valoresPorDefecto() {
        FabricaServicioHospedajeNoche fabrica = new FabricaServicioHospedajeNoche();
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
            salida.contains("Ejecutando servicio de Hospedaje Nocturno"),
            "Salida esperada: 'Ejecutando servicio de Hospedaje Nocturno'. Fue: " + salida
        );

        assertEquals(1.0, servicio.getPrecio(), 1e-9);
    }
}
