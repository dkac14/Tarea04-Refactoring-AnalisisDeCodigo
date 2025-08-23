package com.mycompany.petdaycare.Composite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PaqueteServicio extends Servicio {
    private final List<Servicio> servicios = new ArrayList<>();
    private static final BigDecimal DESCUENTO_PAQUETE = new BigDecimal("0.10");

    public void addServicio(Servicio s) {
        Objects.requireNonNull(s, "El servicio no puede ser null");
        
        if (!servicios.isEmpty() && s.getCurrency() != null && !s.getCurrency().equals(this.currency)) {
            throw new IllegalArgumentException("Todos los servicios del paquete deben tener la misma moneda");
        }
        if (servicios.isEmpty()) {
            this.currency = s.getCurrency(); 
        }
        servicios.add(s);
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
        if (servicios.isEmpty()) return BigDecimal.ZERO;

        BigDecimal total = BigDecimal.ZERO;
        for (Servicio s : servicios) {
            total = total.add(s.getPrecio());
        }
        return total.multiply(BigDecimal.ONE.subtract(DESCUENTO_PAQUETE));
    }
}
