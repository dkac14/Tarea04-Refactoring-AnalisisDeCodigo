package com.mycompany.petdaycare.Composite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ServicioPaseoTest {

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
    void SP001_ejecutar_imprimeMensajeEsperado() {
        ServicioPaseo servicio = new ServicioPaseo();

        servicio.ejecutar();

        String salida = baos.toString().trim();
        assertFalse(salida.isBlank(), "No se capturó salida en consola");
        assertTrue(
            salida.contains("Ejecutando servicio de Paseo"),
            "La salida debe contener: 'Ejecutando servicio de Paseo'. Fue: " + salida
        );
    }
}
