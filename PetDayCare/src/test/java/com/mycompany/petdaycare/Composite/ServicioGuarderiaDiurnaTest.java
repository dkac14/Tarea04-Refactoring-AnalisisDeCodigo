package com.mycompany.petdaycare.Composite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ServicioGuarderiaDiurnaTest {

    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(baos));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    
    @Test
    void SG001_ejecutar_imprimeMensajeEsperado() {
        ServicioGuarderiaDiurna servicio = new ServicioGuarderiaDiurna();

        servicio.ejecutar();

        String salida = baos.toString().trim();
        assertFalse(salida.isBlank(), "No se capturó salida en consola");
        assertTrue(
            salida.contains("Ejecutando servicio de Guardería Diurna"),
            "La salida debe contener: 'Ejecutando servicio de Guardería Diurna'. Fue: " + salida
        );
    }
}
