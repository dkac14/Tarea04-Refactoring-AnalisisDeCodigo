package com.mycompany.petdaycare.Centro;

import java.util.Objects;

public final class CentroSimple implements Centro {
    private final TipoCentro tipo;
    private final String descripcion;

    private CentroSimple(TipoCentro tipo, String descripcion) {
        this.tipo = Objects.requireNonNull(tipo, "tipo");
        this.descripcion = Objects.requireNonNull(descripcion, "descripcion");
    }

    public static CentroSimple of(TipoCentro tipo) {
        return new CentroSimple(tipo, tipo.descripcionPorDefecto());
    }

    public static CentroSimple of(TipoCentro tipo, String descripcionPersonalizada) {
        return new CentroSimple(tipo, descripcionPersonalizada);
    }

    public TipoCentro getTipo() { return tipo; }

    @Override public String getDescripcion() { return descripcion; }
}
