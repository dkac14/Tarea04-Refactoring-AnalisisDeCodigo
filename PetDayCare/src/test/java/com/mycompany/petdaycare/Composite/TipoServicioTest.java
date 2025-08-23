package com.mycompany.petdaycare.Composite;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Currency;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TipoServicioTest {

    @Test
    @DisplayName("Verificar que cada TipoServicio tenga el nombre correcto")
    void testNombres() {
        assertEquals("Paseo", TipoServicio.PASEO.getNombre());
        assertEquals("Entrenamiento", TipoServicio.ENTRENAMIENTO.getNombre());
        assertEquals("Guardería Diurna", TipoServicio.GUARDERIA_DIURNA.getNombre());
        assertEquals("Hospedaje Nocturno", TipoServicio.HOSPEDAJE_NOCTURNO.getNombre());
    }

    @Test
    @DisplayName("Verificar que cada TipoServicio tenga la descripción correcta")
    void testDescripciones() {
        assertEquals("Paseo de mascotas al aire libre.", TipoServicio.PASEO.getDescripcion());
        assertEquals("Entrenamiento básico para mascotas.", TipoServicio.ENTRENAMIENTO.getDescripcion());
        assertEquals("Cuidado diurno para mascotas.", TipoServicio.GUARDERIA_DIURNA.getDescripcion());
        assertEquals("Servicio de hospedaje nocturno para mascotas.", TipoServicio.HOSPEDAJE_NOCTURNO.getDescripcion());
    }

    @Test
    @DisplayName("Verificar que cada TipoServicio tenga el precio correcto")
    void testPrecios() {
        assertEquals(0, TipoServicio.PASEO.getPrecio().compareTo(new BigDecimal("15.00")));
        assertEquals(0, TipoServicio.ENTRENAMIENTO.getPrecio().compareTo(new BigDecimal("25.00")));
        assertEquals(0, TipoServicio.GUARDERIA_DIURNA.getPrecio().compareTo(new BigDecimal("35.00")));
        assertEquals(0, TipoServicio.HOSPEDAJE_NOCTURNO.getPrecio().compareTo(new BigDecimal("45.00")));
    }

    @Test
    @DisplayName("Verificar que la moneda sea USD")
    void testMoneda() {
        Currency monedaEsperada = Currency.getInstance("USD");
        for (TipoServicio ts : TipoServicio.values()) {
            assertEquals(monedaEsperada, ts.getMoneda(), "La moneda debe ser USD para " + ts.getNombre());
        }
    }

    @Test
    @DisplayName("Iterar todos los valores sin errores")
    void testIteracionValores() {
        assertDoesNotThrow(() -> {
            for (TipoServicio ts : TipoServicio.values()) {
                ts.getNombre();
                ts.getDescripcion();
                ts.getPrecio();
                ts.getMoneda();
            }
        });
    }
}
