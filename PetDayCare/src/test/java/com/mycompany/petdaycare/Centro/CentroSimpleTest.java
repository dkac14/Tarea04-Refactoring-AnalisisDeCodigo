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
public class CentroSimpleTest {
    @Test
    void CS01_of_conTipo_usaDescripcionPorDefecto() {
        TipoCentro tipo = TipoCentro.values()[0];
        CentroSimple centro = CentroSimple.of(tipo);

        assertSame(tipo, centro.getTipo());
        assertEquals(tipo.descripcionPorDefecto(), centro.getDescripcion());
    }

    @Test
    void CS02_of_conTipoYDescripcionPersonalizada_respetaValor() {
        TipoCentro tipo = TipoCentro.values()[0];
        String personalizada = "Guardería 24/7 con monitoreo";

        CentroSimple centro = CentroSimple.of(tipo, personalizada);

        assertSame(tipo, centro.getTipo());
        assertEquals(personalizada, centro.getDescripcion());
    }

    @Test
    void CS03_of_conDescripcionNull_lanzaNPE_conMensajeDescripcion() {
        TipoCentro tipo = TipoCentro.values()[0];

        NullPointerException ex =
            assertThrows(NullPointerException.class, () -> CentroSimple.of(tipo, null));

        assertEquals("descripcion", ex.getMessage());
    }

}
