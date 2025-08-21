package com.mycompany.petdaycare.ChainOfResponsability;

public abstract class ManejadorIncidenteBase implements ManejadorIncidente {
    protected ManejadorIncidente next;

    @Override
    public void setNext(ManejadorIncidente m) {
        this.next = m;
    }

    @Override
    public void handle(String incidente) {
        if (next != null) {
            next.handle(incidente);
        }
    }


}
