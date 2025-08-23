/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.petdaycare.ChainOfResponsability;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenovo
 */
public class EquipoAtencionGeneralTest {
    
   private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testHandleIncidenteMedioNivel() {
        
        EquipoAtencionGeneral equipo = new EquipoAtencionGeneral();
        String incidente = "El perro presenta comportamiento medio agresivo";

        
        equipo.handle(incidente);

        
        String salida = outputStream.toString().trim();
        assertTrue(salida.contains("Equipo de atención general resolvió el incidente"), "El equipo debería manejar el incidente");
        assertTrue(salida.contains(incidente));
    }

    @Test
    void testHandleIncidenteEscaladoMasArriba() {
        
        EquipoAtencionGeneral equipo = new EquipoAtencionGeneral();
        ManejadorIncidenteMock siguiente = new ManejadorIncidenteMock();
        equipo.setNext(siguiente);

        String incidente = "Incidente crítico";

       
        equipo.handle(incidente);

        
        assertTrue(siguiente.fueInvocado, "El siguiente manejador en la cadena debe ser invocado");
    }

    @Test
    void testHandleSinSiguienteEnCadenaNoFalla() {
        
        EquipoAtencionGeneral equipo = new EquipoAtencionGeneral();
        String incidente = "Incidente de nivel alto";

        
        assertDoesNotThrow(() -> equipo.handle(incidente), "No debe lanzar excepción si no hay siguiente manejador");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }


    static class ManejadorIncidenteMock extends ManejadorIncidenteBase {
        boolean fueInvocado = false;

        @Override
        public void handle(String incidente) {
            fueInvocado = true;
        }
    }
   
}
