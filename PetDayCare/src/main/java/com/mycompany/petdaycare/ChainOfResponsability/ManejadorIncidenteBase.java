package com.mycompany.petdaycare.ChainOfResponsability;

public abstract class ManejadorIncidenteBase implements ManejadorIncidente {
    protected ManejadorIncidente next = new ManejadorNulo(); // Nunca será null

    @Override
    public void setNext(ManejadorIncidente m) {
        this.next = (m != null) ? m : new ManejadorNulo();
    }

    @Override
    public void handle(String incidente) {
        next.handle(incidente);
    }

    public boolean isNull() {
        return false;
    }
}
