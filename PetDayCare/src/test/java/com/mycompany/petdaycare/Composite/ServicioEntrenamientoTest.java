package com.mycompany.petdaycare.Composite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioEntrenamientoTest {

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
    void SE001_ejecutar_imprimeMensajeEsperado() {
        ServicioEntrenamiento instance = new ServicioEntrenamiento();

        instance.ejecutar();

        String salida = baos.toString().trim();
        assertFalse(salida.isBlank(), "No se capturó salida en consola");
        assertTrue(
            salida.contains("Ejecutando servicio de Entrenamiento"),
            "La salida debe contener: 'Ejecutando servicio de Entrenamiento'. Fue: " + salida
        );
    }
}
