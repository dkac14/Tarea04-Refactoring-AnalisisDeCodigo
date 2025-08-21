package com.mycompany.petdaycare.Composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PaqueteServicio extends Servicio {
    private final List<Servicio> servicios = new ArrayList<>();

    public void addServicio(Servicio s) {
        // PS003: lanzar NPE si s es null
        servicios.add(Objects.requireNonNull(s, "El servicio no puede ser null"));
    }

    public void removeServicio(Servicio s) {
        // PS006: lanzar NPE si s es null
        if (s == null) {
            throw new NullPointerException("El servicio no puede ser null");
        }
        servicios.remove(s);
    }

    public Servicio getServicio(int index) {
        return servicios.get(index); // PS009: fuera de rango lanza IndexOutOfBoundsException
    }

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando paquete:");
        for (Servicio s : servicios) {
            s.ejecutar(); // PS007: ejecuta todos; PS008: si está vacío, no falla
        }
    }

    @Override
    public double getPrecio() {
        double total = 0.0;
        for (Servicio s : servicios) {
            total += s.getPrecio();
        }
        return total * 0.9; // 10% de descuento del paquete
    }
}
