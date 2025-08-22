package com.mycompany.petdaycare.Centro;

public final class CentroFactory {

    public Centro create(TipoCentro tipo) {
        return CentroSimple.of(tipo);
    }

    public Centro create(TipoCentro tipo, String descripcionPersonalizada) {
        return CentroSimple.of(tipo, descripcionPersonalizada);
    }
}
