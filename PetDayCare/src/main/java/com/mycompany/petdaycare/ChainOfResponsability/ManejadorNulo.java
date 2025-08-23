package com.mycompany.petdaycare.ChainOfResponsability;

public class ManejadorNulo extends ManejadorIncidenteBase {
    @Override
    public void handle(String incidente) {
        
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
