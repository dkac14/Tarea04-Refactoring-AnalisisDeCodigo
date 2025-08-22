package com.mycompany.petdaycare.Composite;

public enum TipoServicio {
    PASEO("Paseo", "Paseo de mascotas al aire libre.", 1.0),
    ENTRENAMIENTO("Entrenamiento", "Entrenamiento básico para mascotas.", 3.0),
    GUARDERIA_DIURNA("Guardería Diurna", "Cuidado diurno para mascotas.", 10.0),
    HOSPEDAJE_NOCTURNO("Hospedaje Nocturno", "Servicio de hospedaje nocturno para mascotas.", 1.0);
    
    private final String nombre;
    private final String descripcion;
    private final double precio;
    
    private TipoServicio(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
}
