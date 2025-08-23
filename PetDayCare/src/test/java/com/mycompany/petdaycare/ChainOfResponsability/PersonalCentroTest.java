package com.mycompany.petdaycare.ChainOfResponsability;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonalCentroTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testHandleIncidenteResueltoPorPersonalCentro() {
        PersonalCentro personalCentro = new PersonalCentro();
        String incidente = "El agua del bebedero está muy bajo"; 

        personalCentro.handle(incidente);

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Personal del centro resolvió el incidente"),
                "Debe resolverse por el PersonalCentro");
        assertTrue(output.contains(incidente),
                "Debe incluir el incidente en el mensaje");
    }

    @Test
    void testHandleIncidenteEscaladoAOtroManejador() {
        PersonalCentro personalCentro = new PersonalCentro();
        
        ManejadorIncidenteBase siguiente = new ManejadorIncidenteBase() {
            @Override
            public void handle(String incidente) {
                System.out.println("Incidente escalado: " + incidente);
            }
        };

        personalCentro.setNext(siguiente);

        String incidente = "El perro escapó de la zona segura. tipo: medio"; 

        personalCentro.handle(incidente);

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Incidente escalado"),
                "Debe escalarse al siguiente manejador en la cadena");
        assertTrue(output.contains(incidente),
                "El mensaje escalado debe incluir el incidente original");
    }

    @Test
    void testHandleSinSiguienteEnCadenaNoLanzaExcepcion() {
        PersonalCentro personalCentro = new PersonalCentro();
        String incidente = "Algo grave ocurrió"; 

        assertDoesNotThrow(() -> personalCentro.handle(incidente),
                "No debe lanzar excepción si no hay siguiente manejador");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}
