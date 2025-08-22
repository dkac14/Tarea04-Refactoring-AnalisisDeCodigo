package com.mycompany.petdaycare.Composite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class PaqueteServicio extends Servicio {
    private final List<Servicio> servicios = new ArrayList<>();
    private static final BigDecimal DESCUENTO_PAQUETE = new BigDecimal("0.10"); 

    public void addServicio(Servicio s) {
        servicios.add(Objects.requireNonNull(s, "El servicio no puede ser null"));
        validarMonedaConsistente(s);
    }
    public void removeServicio(Servicio s) {
        servicios.remove(Objects.requireNonNull(s, "El servicio no puede ser null"));
    }
    public Servicio getServicio(int index) {
        return servicios.get(index);
    }
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando paquete:");
        for (Servicio s : servicios) {
            s.ejecutar();
        }
    }
    @Override
    public BigDecimal getPrecio() {
        if (servicios.isEmpty()) {
            return BigDecimal.ZERO;
        }
        BigDecimal total = BigDecimal.ZERO;
        for (Servicio s : servicios) {
            total = total.add(s.getPrecio());
        }
        BigDecimal factorDescuento = BigDecimal.ONE.subtract(DESCUENTO_PAQUETE);
        return total.multiply(factorDescuento);
    }
    private void validarMonedaConsistente(Servicio nuevoServicio) {
        if (servicios.isEmpty()) {
            this.currency = nuevoServicio.getCurrency();
            return;
        }
        if (!nuevoServicio.getCurrency().equals(this.currency)) {
            throw new IllegalArgumentException("Todos los servicios del paquete deben tener la misma moneda");
        }
    }
}
