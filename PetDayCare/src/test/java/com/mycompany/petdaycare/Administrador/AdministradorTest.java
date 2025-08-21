/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.petdaycare.Administrador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.petdaycare.Administrador.Administrador;
import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioEntrenamiento;

public class AdministradorTest {
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut); 
    }

    @Test
    void ADM01_actualizaCamposEImprime() {
        
        Servicio servicio = new ServicioEntrenamiento(); 
        Administrador admin = new Administrador("Ana");

        admin.cambiarDetallesServicio(servicio,"Entrenamiento Avanzado","Entrenamiento especializado para perros con experiencia.",15.0);

        assertEquals("Entrenamiento Avanzado", servicio.getNombre());
        assertEquals("Entrenamiento especializado para perros con experiencia.", servicio.getDescripcion());
        assertEquals(15.0, servicio.getPrecio(), 1e-9);

        
        String consola = outputStream.toString(StandardCharsets.UTF_8);
        assertTrue(consola.contains("Detalles del servicio actualizados por Ana"));
    }

    @Test
    void ADM02_conServicioNull() {

        Administrador admin = new Administrador("Ana");

        assertThrows(NullPointerException.class, () ->
            admin.cambiarDetallesServicio(null, "Nuevo", "Desc", 10.0)
        );

        String consola = outputStream.toString(StandardCharsets.UTF_8);
        assertFalse(consola.contains("Detalles del servicio actualizados por"));
    }



}
