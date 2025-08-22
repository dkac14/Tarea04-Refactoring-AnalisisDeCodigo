package com.mycompany.petdaycare.Composite;

import java.math.BigDecimal;
import java.util.Currency;

public enum TipoServicio {
    PASEO("Paseo", "Paseo de mascotas al aire libre.", new BigDecimal("15.00")),
    ENTRENAMIENTO("Entrenamiento", "Entrenamiento básico para mascotas.", new BigDecimal("25.00")),
    GUARDERIA_DIURNA("Guardería Diurna", "Cuidado diurno para mascotas.", new BigDecimal("35.00")),
    HOSPEDAJE_NOCTURNO("Hospedaje Nocturno", "Servicio de hospedaje nocturno para mascotas.", new BigDecimal("45.00"));

    private final String nombre;
    private final String descripcion;
    private final BigDecimal precio;
    private static final Currency MONEDA_PREDETERMINADA = Currency.getInstance("USD");
    
    private TipoServicio(String nombre, String descripcion, BigDecimal precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public BigDecimal getPrecio() { return precio; }
    public Currency getMoneda() { return MONEDA_PREDETERMINADA; }
}