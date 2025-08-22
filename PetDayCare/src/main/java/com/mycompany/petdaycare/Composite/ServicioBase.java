package com.mycompany.petdaycare.Composite;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;

public class ServicioBase extends Servicio {
    public ServicioBase(String nombre, String descripcion, CategoriaCuidado categoria, BigDecimal precio, Currency currency) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser null");
        this.descripcion = Objects.requireNonNull(descripcion, "La descripción no puede ser null");
        this.categoria = Objects.requireNonNull(categoria, "La categoría no puede ser null");
        setPrecio(precio);
        setCurrency(currency);
    }
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando el servicio: " + nombre);
    }
}
