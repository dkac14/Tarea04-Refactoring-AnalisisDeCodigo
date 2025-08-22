package com.mycompany.petdaycare.Centro;

public enum TipoCentro {
    ATENCION("Centro dedicado a la atención del cliente"),
    RURAL("Centro dedicado al cuidado de animales del área rural"),
    URBANO("Centro dedicado al cuidado de animales del área urbana");

    private final String descripcionPorDefecto;

    TipoCentro(String d) {
        this.descripcionPorDefecto = d;
    }

    public String descripcionPorDefecto() {
        return descripcionPorDefecto;
    }
}
