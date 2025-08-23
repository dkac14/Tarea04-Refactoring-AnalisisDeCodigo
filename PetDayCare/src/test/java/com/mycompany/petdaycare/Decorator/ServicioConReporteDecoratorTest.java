package com.mycompany.petdaycare.Decorator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.petdaycare.Composite.Servicio;

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
    void SRD01_ejecutar_conMensajeBase() {
        Servicio servicioBase = new Servicio() {
            @Override public void ejecutar() { System.out.println("Base ejecutado"); }
            @Override public BigDecimal getPrecio() { return BigDecimal.valueOf(50); }
        };

        ServicioConReporteDecorator decorador = new ServicioConReporteDecorator(servicioBase);
        decorador.ejecutar(); // ya aplica decoración automáticamente

        String salida = outputStream.toString();
        assertTrue(salida.contains("Base ejecutado"));
        assertTrue(salida.contains("+ Reporte generado"));
    }

    @Test
    void SRD02_ejecutar_sinMensajeBase() {
        Servicio servicioBase = new Servicio() {
            @Override public void ejecutar() { }
            @Override public BigDecimal getPrecio() { return BigDecimal.ZERO; }
        };

        ServicioConReporteDecorator decorador = new ServicioConReporteDecorator(servicioBase);
        decorador.ejecutar(); // ya aplica decoración automáticamente

        String salida = outputStream.toString();
        assertFalse(salida.contains("Base ejecutado"));
        assertTrue(salida.contains("+ Reporte generado"));
    }

    @Test
    void SRD03_servicioNull_lanzaNPE() {
        // Ahora la clase lanza NullPointerException al pasar null
        assertThrows(NullPointerException.class, () -> new ServicioConReporteDecorator(null));
    }
}
