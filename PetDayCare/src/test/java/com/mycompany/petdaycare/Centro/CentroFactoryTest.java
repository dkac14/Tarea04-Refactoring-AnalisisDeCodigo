package com.mycompany.petdaycare.Centro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CentroFactoryTest {
    @Test
    void CF01_create_porDefecto_devuelveCentroSimpleConDescripcionPorDefecto() {
        TipoCentro tipo = TipoCentro.values()[0];
        CentroFactory factory = new CentroFactory();

        Centro centro = factory.create(tipo);

        assertTrue(centro instanceof CentroSimple);
        assertEquals(tipo.descripcionPorDefecto(), centro.getDescripcion());
    }

    @Test
    void CF02_create_personalizado_respetaDescripcion() {
        TipoCentro tipo = TipoCentro.values()[0];
        String personalizada = "Peluquería premium para razas pequeñas";
        CentroFactory factory = new CentroFactory();

        Centro centro = factory.create(tipo, personalizada);

        assertTrue(centro instanceof CentroSimple);
        assertEquals(personalizada, centro.getDescripcion());
    }

    @Test
    void CF03_create_conTipoNull_lanzaNPE() {
        CentroFactory factory = new CentroFactory();

        // CentroSimple.of(null) terminará lanzando NPE (se evalúa tipo.descripcionPorDefecto())
        assertThrows(NullPointerException.class, () -> factory.create(null));
    }
}
