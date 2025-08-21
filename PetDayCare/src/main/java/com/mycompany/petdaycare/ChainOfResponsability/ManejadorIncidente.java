package com.mycompany.petdaycare.ChainOfResponsability;

public interface ManejadorIncidente {
    void setNext(ManejadorIncidente m);
    void handle(String incidente);
}
