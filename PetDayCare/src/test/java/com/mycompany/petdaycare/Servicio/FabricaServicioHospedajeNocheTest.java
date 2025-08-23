package com.mycompany.petdaycare.Servicio;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;
import com.mycompany.petdaycare.Composite.Servicio;
import com.mycompany.petdaycare.Composite.ServicioBase;
import com.mycompany.petdaycare.Composite.TipoServicio;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FabricaServicioHospedajeNocheTest {

    
    @Test
    void FH001_createServicio_retornaInstanciaCorrecta() {
        FabricaServicioHospedajeNoche fabrica = new FabricaServicioHospedajeNoche();

        Servicio servicio = fabrica.createServicio();

        assertNotNull(servicio, "El servicio no debe ser null");
        assertTrue(servicio instanceof ServicioBase, "Debe ser instancia de ServicioBase");

        assertEquals(TipoServicio.HOSPEDAJE_NOCTURNO.getNombre(), servicio.getNombre());
        assertEquals(TipoServicio.HOSPEDAJE_NOCTURNO.getDescripcion(), servicio.getDescripcion());
        assertEquals(TipoServicio.HOSPEDAJE_NOCTURNO.getPrecio(), servicio.getPrecio());
        assertEquals(TipoServicio.HOSPEDAJE_NOCTURNO.getMoneda(), servicio.getCurrency());
        assertEquals(CategoriaCuidado.BASICA, servicio.getCategoria());
    }

    @Test
    void FH002_createServicio_instanciasIndependientes() {
        FabricaServicioHospedajeNoche fabrica = new FabricaServicioHospedajeNoche();

        Servicio s1 = fabrica.createServicio();
        Servicio s2 = fabrica.createServicio();

        assertNotNull(s1);
        assertNotNull(s2);
        assertNotSame(s1, s2, "Cada invocación debe devolver instancias distintas");


        assertEquals(s1.getNombre(), s2.getNombre());
        assertEquals(s1.getDescripcion(), s2.getDescripcion());
        assertEquals(s1.getPrecio(), s2.getPrecio());
        assertEquals(s1.getCurrency(), s2.getCurrency());
        assertEquals(s1.getCategoria(), s2.getCategoria());
    }

    @Test
    void FH003_createServicio_valoresPorDefectoYEjecucion() {
        FabricaServicioHospedajeNoche fabrica = new FabricaServicioHospedajeNoche();
        Servicio servicio = fabrica.createServicio();

        // Capturar salida de ejecutar()
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(baos));
        try {
            servicio.ejecutar();
        } finally {
            System.setOut(original);
        }
        String salida = baos.toString().trim();

        assertTrue(
            salida.contains("Ejecutando el servicio: " + TipoServicio.HOSPEDAJE_NOCTURNO.getNombre()),
            "Salida esperada que contenga: 'Ejecutando el servicio: Hospedaje Nocturno'. Fue: " + salida
        );

        // Verificar precio y moneda definidos en TipoServicio
        assertEquals(TipoServicio.HOSPEDAJE_NOCTURNO.getPrecio(), servicio.getPrecio());
        assertEquals(TipoServicio.HOSPEDAJE_NOCTURNO.getMoneda(), servicio.getCurrency());
    }
}
