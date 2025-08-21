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
import com.mycompany.petdaycare.Decorator.ServicioConReporteDecorator;

public class ServicioConReporteDecoratorTest {

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
    void SRD_01_ejecutar_conMensajeBase() {
        Servicio servicioBase = new Servicio() {
            @Override public void ejecutar() { System.out.println("Base ejecutado"); }
            @Override public double getPrecio() { return 50; }
        };

        ServicioConReporteDecorator decorador = new ServicioConReporteDecorator(servicioBase);
        decorador.ejecutar();

        String salida = outputStream.toString();
        assertTrue(salida.contains("Base ejecutado"));
        assertTrue(salida.contains("+ Reporte generado"));
    }

    @Test
    void SRD_02_ejecutar_sinMensajeBase() {
        Servicio servicioBase = new Servicio() {
            @Override public void ejecutar() { }
            @Override public double getPrecio() { return 0; }
        };

        ServicioConReporteDecorator decorador = new ServicioConReporteDecorator(servicioBase);
        decorador.ejecutar();

        String salida = outputStream.toString();
        assertFalse(salida.contains("Base ejecutado"));
        assertTrue(salida.contains("+ Reporte generado"));
    }

    @Test
    void SRD_03_ejecutar_servicioNull_lanzaNPE() {
        ServicioConReporteDecorator decorador = new ServicioConReporteDecorator(null);
        assertThrows(NullPointerException.class, decorador::ejecutar);
    }
}

