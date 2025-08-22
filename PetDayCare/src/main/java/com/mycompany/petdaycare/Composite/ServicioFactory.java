package com.mycompany.petdaycare.Composite;

import java.math.BigDecimal;
import java.util.Currency;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;

public final class ServicioFactory {

    public static Servicio crearServicio(TipoServicio tipo) {
        return new ServicioBase(
            tipo.getNombre(),
            tipo.getDescripcion(),
            CategoriaCuidado.BASICA, 
            tipo.getPrecio(), 
            tipo.getMoneda() 
        );
    }
    public static Servicio crearServicioPersonalizado(String nombre, String descripcion, CategoriaCuidado categoria, BigDecimal precio,Currency currency) {
        return new ServicioBase(nombre, descripcion, categoria, precio, currency);
    }
}