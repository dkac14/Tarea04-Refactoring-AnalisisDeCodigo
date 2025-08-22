/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.petdaycare.Centro;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenovo
 */
public class CentroTest {
    
    public CentroTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getDescripcion method, of class CentroAtencion.
     */
    /*@Test
    void getDescripcion_debeRetornarTextoPorDefecto() {
        Centro centro = new CentroAtencion();
        String esperado = "Centro dedicado a la atención del cliente";

        String descripcion = centro.getDescripcion();

        assertNotNull(descripcion);
        assertEquals(esperado, descripcion);
    }
    
    @Test
    void getDescripcion_retornaTextoEsperado() {
        Centro centro = new CentroRural();
        String esperado = "Centro dedicado al cuidado de animales del área rural";

        String descripcion = centro.getDescripcion();

        assertNotNull(descripcion, "La descripción no debe ser null");
        assertEquals(esperado, descripcion);
    }
    
    
    @Test
    void getDescripcion_retornaTextoEsperado2() {
        Centro centro = new CentroUrbano();
        String esperado = "Centro dedicado al cuidado de animales del área urbana";

        String descripcion = centro.getDescripcion();

        assertNotNull(descripcion, "La descripción no debe ser null");
        assertEquals(esperado, descripcion);
    }*/
    
}
