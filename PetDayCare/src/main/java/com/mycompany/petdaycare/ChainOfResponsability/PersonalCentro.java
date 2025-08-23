package com.mycompany.petdaycare.ChainOfResponsability;

public class PersonalCentro extends ManejadorIncidenteBase {
    @Override
    public void handle(String incidente) {
        if (incidente != null && incidente.contains("bajo")) {
            System.out.println("Personal del centro resolvió el incidente: " + incidente);
        } else if (next != null) {
            next.handle(incidente); // delega solo si hay siguiente
        }
        // Si no hay siguiente, no hace nada (no lanza excepción)
    }
}
