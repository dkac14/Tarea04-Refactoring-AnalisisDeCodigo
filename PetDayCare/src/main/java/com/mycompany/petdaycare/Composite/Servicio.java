package com.mycompany.petdaycare.Composite;

import java.util.ArrayList;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;
import com.mycompany.petdaycare.Mascota.Mascota;

public abstract class Servicio {
    protected CategoriaCuidado categoria;
    protected ArrayList<Mascota> mascotas = new ArrayList<>();
    protected String nombre;
    protected String descripcion;
    protected double precio;

    public void actualizarDetalles(String nuevoNombre, String nuevaDescripcion, double nuevoPrecio){
        this.nombre = nuevoNombre;
        this.descripcion = nuevaDescripcion;
        this.precio = nuevoPrecio;
    }

    public abstract void ejecutar(); 

    public double getPrecio() { return precio; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public CategoriaCuidado getCategoria() { return categoria; }
    public ArrayList<Mascota> getMascotas() { return mascotas; }

    public void setCategoria(CategoriaCuidado categoria) { this.categoria = categoria; }
    public void setMascotas(ArrayList<Mascota> mascotas) { this.mascotas = mascotas; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(double precio) { this.precio = precio; }

}
