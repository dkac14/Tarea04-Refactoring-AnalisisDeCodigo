/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.petdaycare.Observer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.petdaycare.Observer.UsuarioCliente;

/**
 *
 * @author Lenovo
 */
public class UsuarioClienteTest {
    private final ByteArrayOutputStream salidaConsola = new ByteArrayOutputStream();
    private final PrintStream salidaOriginal = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(salidaConsola));
    }

    @AfterEach
    void tearDown() {
        System.setOut(salidaOriginal); // Restaurar salida estándar
    }
    
    @Test
    void testUpdateConMensajeNull() {
        String nombre = "Luis";
        UsuarioCliente usuario = new UsuarioCliente(nombre);
        String mensaje = null;

        usuario.update(mensaje);

        String salida = salidaConsola.toString().trim();
        String esperado = nombre + " ha recibido una actualización: null";

        assertEquals(esperado, salida);
    }

    @Test
    void testUpdateConMensajeVacio() {
        String nombre = "Carlos";
        UsuarioCliente usuario = new UsuarioCliente(nombre);
        String mensaje = "";

        usuario.update(mensaje);

        String salida = salidaConsola.toString().trim();
        String esperado = nombre + " ha recibido una actualización:" + mensaje;

        assertEquals(esperado, salida);
    }

    @Test
    void testUpdateConMensajeLargo() {
        String nombre = "María";
        UsuarioCliente usuario = new UsuarioCliente(nombre);
        String mensaje = "Se ha actualizado el horario de atención del centro de mascotas.";

        usuario.update(mensaje);

        String salida = salidaConsola.toString().trim();
        String esperado = nombre + " ha recibido una actualización: " + mensaje;

        assertEquals(esperado, salida);
    }
}
