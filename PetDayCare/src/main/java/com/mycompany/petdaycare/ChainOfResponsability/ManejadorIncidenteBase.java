package com.mycompany.petdaycare.ChainOfResponsability;

public abstract class ManejadorIncidenteBase implements ManejadorIncidente {
    protected ManejadorIncidente next; // puede ser null

    @Override
    public void setNext(ManejadorIncidente m) {
        this.next = m;
    }

    @Override
    public void handle(String incidente) {
        if (next != null) {
            next.handle(incidente);
        }
        // si no hay next, simplemente no hace nada
    }

    public boolean isNull() {
        return false;
    }
}
