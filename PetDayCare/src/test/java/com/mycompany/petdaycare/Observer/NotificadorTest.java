/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.petdaycare.Observer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
public class NotificadorTest {
    
     private PrintStream originalOut;
    private ByteArrayOutputStream out;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

   
    private String salida() { return out.toString(); }
    private static int count(String s, String needle) {
        int c = 0, i = 0;
        while ((i = s.indexOf(needle, i)) != -1) { c++; i += needle.length(); }
        return c;
    }

    @Test
    void PC_NOT01_notificar_sinUsuarios_noLanza() {
        Notificador n = new Notificador();
        assertDoesNotThrow(n::notificarUsuario);
        assertTrue(salida().isEmpty());
    }

    @Test
    void PC_NOT02_unDuenio_recibeMensaje() {
        Notificador n = new Notificador();
        UsuarioCliente ana = new UsuarioCliente("Ana");
        n.agregarUsuario(ana);
        n.setEstado("PASEO_EN_CAMINO");

        n.notificarUsuario();

        assertTrue(salida().contains("Ana ha recibido una actualización: PASEO_EN_CAMINO"));
    }

    @Test
    void PC_NOT03_dosDuenios_recibenAmbos() {
        Notificador n = new Notificador();
        UsuarioCliente ana = new UsuarioCliente("Ana");
        UsuarioCliente luis = new UsuarioCliente("Luis");
        n.agregarUsuario(ana);
        n.agregarUsuario(luis);
        n.setEstado("BAÑO_COMPLETADO");

        n.notificarUsuario();

        String s = salida();
        assertTrue(s.contains("Ana ha recibido una actualización: BAÑO_COMPLETADO"));
        assertTrue(s.contains("Luis ha recibido una actualización: BAÑO_COMPLETADO"));
    }

    @Test
    void PC_NOT04_eliminado_noRecibe() {
        Notificador n = new Notificador();
        UsuarioCliente ana = new UsuarioCliente("Ana");
        UsuarioCliente luis = new UsuarioCliente("Luis");
        n.agregarUsuario(ana);
        n.agregarUsuario(luis);
        n.eliminarUsuario(ana);
        n.setEstado("CONSULTA_VET_CONFIRMADA");

        n.notificarUsuario();

        String s = salida();
        assertFalse(s.contains("Ana ha recibido una actualización:"));
        assertTrue(s.contains("Luis ha recibido una actualización: CONSULTA_VET_CONFIRMADA"));
    }

    @Test
    void PC_NOT05_cambiosDeEstado_enOrden() {
        Notificador n = new Notificador();
        UsuarioCliente ana = new UsuarioCliente("Ana");
        n.agregarUsuario(ana);

        n.setEstado("PASEO_INICIADO");   n.notificarUsuario();
        n.setEstado("PASEO_FINALIZADO"); n.notificarUsuario();

        String s = salida();
        int i1 = s.indexOf("Ana ha recibido una actualización: PASEO_INICIADO");
        int i2 = s.indexOf("Ana ha recibido una actualización: PASEO_FINALIZADO");
        assertTrue(i1 >= 0 && i2 >= 0 && i1 < i2);
    }

    @Test
    void PC_NOT06_duplicado_recibeDoble() {
        Notificador n = new Notificador();
        UsuarioCliente ana = new UsuarioCliente("Ana");
        n.agregarUsuario(ana);
        n.agregarUsuario(ana); // mismo objeto dos veces
        n.setEstado("VACUNACIÓN_PROGRAMADA");

        n.notificarUsuario();

        String linea = "Ana ha recibido una actualización: VACUNACIÓN_PROGRAMADA";
        assertEquals(2, count(salida(), linea));
    }

    @Test
    void PC_NOT07_nullSuscriptor_documentaComportamiento() {
        Notificador n = new Notificador();
        n.agregarUsuario(null);           // si tu código ahora valida null, cambia este test
        n.setEstado("RECORDATORIO_DESPARASITACIÓN");

        // Opción A (implementación actual sin validar): lanza NPE al notificar
        assertThrows(NullPointerException.class, n::notificarUsuario);

        // Opción B (si agregaste validación en agregarUsuario):
        // assertThrows(NullPointerException.class, () -> n.agregarUsuario(null));
    }

    @Test
    void PC_NOT08_eliminarNoSuscrito_noAfecta() {
        Notificador n = new Notificador();
        UsuarioCliente ana = new UsuarioCliente("Ana");
        UsuarioCliente pedro = new UsuarioCliente("Pedro"); // no suscrito
        n.agregarUsuario(ana);
        n.eliminarUsuario(pedro);
        n.setEstado("RECORDATORIO_VACUNA_RABIA");

        n.notificarUsuario();

        String s = salida();
        assertTrue(s.contains("Ana ha recibido una actualización: RECORDATORIO_VACUNA_RABIA"));
        assertFalse(s.contains("Pedro ha recibido una actualización:"));
    }

    @Test
    void PC_NOT09_estadoNull_seImprime() {
        Notificador n = new Notificador();
        UsuarioCliente ana = new UsuarioCliente("Ana");
        n.agregarUsuario(ana);
        n.setEstado(null);

        n.notificarUsuario();

        assertTrue(salida().contains("Ana ha recibido una actualización: null"));
    }

    @Test
    void PC_NOT10_ordenDeRegistro_seRespeta() {
        Notificador n = new Notificador();
        UsuarioCliente ana = new UsuarioCliente("Ana");
        UsuarioCliente luis = new UsuarioCliente("Luis");
        n.agregarUsuario(ana);
        n.agregarUsuario(luis);
        n.setEstado("PASEO_EN_CAMINO");

        n.notificarUsuario();

        String s = salida();
        int iAna  = s.indexOf("Ana ha recibido una actualización: PASEO_EN_CAMINO");
        int iLuis = s.indexOf("Luis ha recibido una actualización: PASEO_EN_CAMINO");
        assertTrue(iAna >= 0 && iLuis >= 0 && iAna < iLuis);
    }
    
}
