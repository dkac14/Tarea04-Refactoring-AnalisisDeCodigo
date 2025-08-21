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

    /*El sistema de ges,ón de reparaciones “ReparaciónApp” es una aplicación basada en consola que
organiza el flujo de reparaciones de celulares desde que los disposi,vos son recibidos por el
técnico principal hasta su asignación a los técnicos especializados y la posterior entrega a los
clientes. Además, el técnico principal se encarga de ges,onar cualquier incidente relacionado con
las reparaciones; en caso de no poder resolverlos, los escala al gerente del servicio técnico. */
}
