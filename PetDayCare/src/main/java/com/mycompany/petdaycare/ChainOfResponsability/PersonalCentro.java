package com.mycompany.petdaycare.ChainOfResponsability;

public class PersonalCentro extends ManejadorIncidenteBase {
    @Override
    public void handle(String incidente) {
        if (incidente.contains("bajo")) {
            System.out.println("Personal del centro resolvió el incidente: " + incidente);
        } else {
            super.handle(incidente);
        }
    }
}
