package com.mycompany.petdaycare.Composite;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class PaqueteServicioTest {

    // Implementación mínima para pruebas
    static class ServicioDummy extends Servicio {
        private final String nombre;
        private final double precio;
        private int ejecuciones = 0;

        ServicioDummy(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        @Override
        public void ejecutar() {
            ejecuciones++;
            System.out.println("Ejecutando servicio: " + nombre);
        }

        @Override
        public double getPrecio() {
            return precio;
        }

        int getEjecuciones() {
            return ejecuciones;
        }
    }

    @Test 
    void PS001_agregaNuevoServicio() {
        PaqueteServicio paquete = new PaqueteServicio();
        ServicioDummy servicioMock1 = new ServicioDummy("A", 10.0);

        paquete.addServicio(servicioMock1);

        assertSame(servicioMock1, paquete.getServicio(0));
    }

    @Test 
    void PS002_seAgregaNormal() {
        PaqueteServicio paquete = new PaqueteServicio();
        ServicioDummy s1 = new ServicioDummy("A", 10.0);
        ServicioDummy s2 = new ServicioDummy("B", 20.0);

        paquete.addServicio(s1);
        paquete.addServicio(s2);

        assertSame(s1, paquete.getServicio(0));
        assertSame(s2, paquete.getServicio(1));
    }

    @Test 
    void PS003_addServicio_conNull() {
        PaqueteServicio paquete = new PaqueteServicio();
        assertThrows(NullPointerException.class, () -> paquete.addServicio(null));
    }

    @Test 
    void PS004_eliminaServicioExistente() {
        PaqueteServicio paquete = new PaqueteServicio();
        ServicioDummy servicioA = new ServicioDummy("A", 10.0);
        ServicioDummy servicioB = new ServicioDummy("B", 20.0);

        paquete.addServicio(servicioA);
        paquete.addServicio(servicioB);

        paquete.removeServicio(servicioA);

        assertSame(servicioB, paquete.getServicio(0));
        assertThrows(IndexOutOfBoundsException.class, () -> paquete.getServicio(1));
    }

    @Test
    void PS005_inexistente_noAlteraLista() {
        PaqueteServicio paquete = new PaqueteServicio();
        ServicioDummy servicioA = new ServicioDummy("A", 10.0);
        ServicioDummy servicioB = new ServicioDummy("B", 20.0);
        ServicioDummy servicioC = new ServicioDummy("C", 30.0); // no se agrega

        paquete.addServicio(servicioA);
        paquete.addServicio(servicioB);

        paquete.removeServicio(servicioC); // no hace nada

        assertSame(servicioA, paquete.getServicio(0));
        assertSame(servicioB, paquete.getServicio(1));
    }

    @Test 
    void PS006_lanzaNullPointerException() {
        PaqueteServicio paquete = new PaqueteServicio();
        assertThrows(NullPointerException.class, () -> paquete.removeServicio(null));
    }

    @Test 
    void PS007_ejecutaTodosEImprimeCabecera() {
        PaqueteServicio paquete = new PaqueteServicio();
        ServicioDummy servicioA = new ServicioDummy("A", 10.0);
        ServicioDummy servicioB = new ServicioDummy("B", 20.0);
        paquete.addServicio(servicioA);
        paquete.addServicio(servicioB);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(baos));
        try {
            paquete.ejecutar();
        } finally {
            System.setOut(original);
        }

        String salida = baos.toString();
        assertTrue(salida.contains("Ejecutando paquete:"), "Debe imprimir la cabecera");
        assertEquals(1, servicioA.getEjecuciones(), "Servicio A debe ejecutarse una vez");
        assertEquals(1, servicioB.getEjecuciones(), "Servicio B debe ejecutarse una vez");
    }

    @Test
    void PS008_ejecutar_listaVacia() {
        PaqueteServicio paquete = new PaqueteServicio();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(baos));
        try {
            assertDoesNotThrow(paquete::ejecutar);
        } finally {
            System.setOut(original);
        }

        String salida = baos.toString().trim();
        assertEquals("Ejecutando paquete:", salida);
    }

    @Test // PS009 (adaptado): IndexOutOfBounds al acceder fuera de rango.
    void PS009_getServicio_fueraDeRango() {
        PaqueteServicio paquete = new PaqueteServicio();
        paquete.addServicio(new ServicioDummy("A", 10.0));

        assertThrows(IndexOutOfBoundsException.class, () -> paquete.getServicio(5));
    }
}
