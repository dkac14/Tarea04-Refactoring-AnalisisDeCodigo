package com.mycompany.petdaycare.ChainOfResponsability;

public class EquipoAtencionGeneral extends ManejadorIncidenteBase {
    @Override
    public void handle(String incidente) {
        if (incidente.contains("medio")) {
            System.out.println("Equipo de atención general resolvió el incidente: " + incidente);
        } else {
            super.handle(incidente);
        }
    }
}
