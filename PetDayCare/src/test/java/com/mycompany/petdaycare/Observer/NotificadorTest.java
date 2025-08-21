/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.petdaycare.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.petdaycare.Observer.Notificador;
import com.mycompany.petdaycare.Observer.Usuario;

public class NotificadorTest {

    private Notificador notificador;

    @BeforeEach
    void setUp() {
        notificador = new Notificador();
    }

    // Mock simple para Usuario
    static class UsuarioMock implements Usuario {
        AtomicBoolean fueNotificado = new AtomicBoolean(false);
        String ultimoMensajeRecibido = null;

        @Override
        public void update(String estado) {
            fueNotificado.set(true);
            ultimoMensajeRecibido = estado;
        }
    }

    // Helper para setear estado privado vía reflexión
    private void setEstado(Notificador notificador, String estado) {
        try {
            var field = Notificador.class.getDeclaredField("estado");
            field.setAccessible(true);
            field.set(notificador, estado);
        } catch (Exception e) {
            fail("Error estableciendo estado: " + e.getMessage());
        }
    }

    @Test
    void testAgregarUsuario() {
        UsuarioMock usuario = new UsuarioMock();

        assertDoesNotThrow(() -> notificador.agregar(usuario));
    }

    @Test
    void testNotificarUsuario_invocaUpdateConEstado() {
        UsuarioMock usuario = new UsuarioMock();
        notificador.agregar(usuario);
        setEstado(notificador, "Mensaje de prueba");

        notificador.notificarUsuario();

        assertTrue(usuario.fueNotificado.get());
        assertEquals("Mensaje de prueba", usuario.ultimoMensajeRecibido);
    }

    @Test
    void testEliminarUsuario_existente() {
        UsuarioMock usuario = new UsuarioMock();
        notificador.agregar(usuario);

        assertDoesNotThrow(() -> notificador.eliminarUsuario(usuario));
    }
}
