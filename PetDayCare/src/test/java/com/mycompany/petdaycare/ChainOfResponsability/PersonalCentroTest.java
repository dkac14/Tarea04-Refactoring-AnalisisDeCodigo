/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.petdaycare.ChainOfResponsability;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.mycompany.petdaycare.ChainOfResponsability.EquipoAtencionGeneral;
import com.mycompany.petdaycare.ChainOfResponsability.PersonalCentro;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenovo
 */
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
        assertTrue(output.contains("Personal del centro resolvió el incidente"), "Debe resolverse por el PersonalCentro");
        assertTrue(output.contains(incidente), "Debe incluir el incidente en el mensaje");
    }
    //FALLOOOOOOOOOOOOOO WAAAAAAAAAA
    @Test
    void testHandleIncidenteEscaladoAOtroManejador() {
        // Arrange
        PersonalCentro personalCentro = new PersonalCentro();
        EquipoAtencionGeneral equipoGeneral = new EquipoAtencionGeneral();

        personalCentro.setNext(equipoGeneral);

        String incidente = "El perro escapó de la zona segura";

        // Act
        personalCentro.handle(incidente);

        // Assert
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Equipo de atención general resolvió el incidente"), "Debe escalarse a EquipoAtencionGeneral");
    }

    @Test
    void testHandleSinSiguienteEnCadenaNoLanzaExcepcion() {
        
        PersonalCentro personalCentro = new PersonalCentro();
        String incidente = "Algo grave ocurrió";

        
        assertDoesNotThrow(() -> personalCentro.handle(incidente), "No debe lanzar excepción si no hay siguiente manejador");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut); 
    }
    
}
