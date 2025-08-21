/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.petdaycare.Decorator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Decorator.ServicioConCameraDecorator;

public class ServicioConCameraDecoratorTest {

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
        outputStream.reset();
    }

    @Test
    void SCC_01_ejecutar_conMensajeBase() {
        Servicio servicioBase = new Servicio() {
            @Override public void ejecutar() { System.out.println("Base ejecutado"); }
            @Override public double getPrecio() { return 50; }
        };

        ServicioConCameraDecorator decorador = new ServicioConCameraDecorator(servicioBase);
        decorador.ejecutar();

        String salida = outputStream.toString();
        assertTrue(salida.contains("Base ejecutado"));
        assertTrue(salida.contains("+ Configuración de cámara añadida"));
    }

    @Test
    void SCC_02_ejecutar_sinMensajeBase() {
        Servicio servicioBase = new Servicio() {
            @Override public void ejecutar() { }
            @Override public double getPrecio() { return 0; }
        };

        ServicioConCameraDecorator decorador = new ServicioConCameraDecorator(servicioBase);
        decorador.ejecutar();

        String salida = outputStream.toString();
        assertFalse(salida.contains("Base ejecutado"));
        assertTrue(salida.contains("+ Configuración de cámara añadida"));
    }

    @Test
    void SCC_03_ejecutar_servicioNull_lanzaNPE() {
        ServicioConCameraDecorator decorador = new ServicioConCameraDecorator(null);
        assertThrows(NullPointerException.class, decorador::ejecutar);
    }
}