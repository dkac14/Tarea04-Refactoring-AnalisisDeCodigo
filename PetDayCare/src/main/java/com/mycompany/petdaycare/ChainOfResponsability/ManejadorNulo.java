package com.mycompany.petdaycare.ChainOfResponsability;

public class ManejadorNulo extends ManejadorIncidenteBase {
    @Override
    public void handle(String incidente) {
        // No hace nada
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
