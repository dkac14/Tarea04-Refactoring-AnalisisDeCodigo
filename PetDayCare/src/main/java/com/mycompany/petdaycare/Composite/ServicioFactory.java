package com.mycompany.petdaycare.Composite;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;

public final class ServicioFactory {
    
    private ServicioFactory() {}

    public static Servicio crearServicio(TipoServicio tipo) {
        return new ServicioBase(
            tipo.getNombre(),
            tipo.getDescripcion(),
            CategoriaCuidado.BASICA, 
            tipo.getPrecio()
        );
    }

    public static Servicio crearServicioPersonalizado(String nombre, String descripcion, CategoriaCuidado categoria, double precio) {
        return new ServicioBase(nombre, descripcion, categoria, precio);
    }
}
