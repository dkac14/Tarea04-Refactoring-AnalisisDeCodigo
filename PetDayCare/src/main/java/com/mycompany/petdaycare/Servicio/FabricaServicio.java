package com.mycompany.petdaycare.Servicio;
import com.mycompany.petdaycare.Composite.Servicio;

public abstract class FabricaServicio {
    
    public abstract Servicio createServicio();

    public void someOperation() {
        Servicio servicio = createServicio();
        servicio.ejecutar();
        System.out.println("Precio del servicio: $" + servicio.getPrecio());
    }
}
