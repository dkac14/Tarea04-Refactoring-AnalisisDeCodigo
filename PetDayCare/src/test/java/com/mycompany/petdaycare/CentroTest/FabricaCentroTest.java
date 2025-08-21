package com.mycompany.petdaycare.CentroTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mycompany.petdaycare.Centro.*;
import com.mycompany.petdaycare.Centro.FabricasCentro.*;

public class FabricaCentroTest {

    @Test
    @DisplayName("FabricaCentroAtencion crea instancias correctas")
    void testFabricaCentroAtencion() {
        FabricaCentro fabrica = new FabricaCentroAtencion();
        Centro centro = fabrica.createCentro();
        assertInstanceOf(CentroAtencion.class, centro);
        assertEquals("Centro dedicado a la atención del cliente", centro.getDescripcion());
    }

    @Test
    @DisplayName("FabricaCentroRural crea instancias correctas")
    void testFabricaCentroRural() {
        FabricaCentro fabrica = new FabricaCentroRural();
        Centro centro = fabrica.createCentro();
        assertInstanceOf(CentroRural.class, centro);
        assertEquals("Centro dedicado al cuidado de animales del área rural", centro.getDescripcion());
    }

    @Test
    @DisplayName("FabricaCentroUrbano crea instancias correctas")
    void testFabricaCentroUrbano() {
        FabricaCentro fabrica = new FabricaCentroUrbano();
        Centro centro = fabrica.createCentro();
        assertInstanceOf(CentroUrbano.class, centro);
        assertEquals("Centro dedicado al cuidado de animales del área urbana", centro.getDescripcion());
    }
}