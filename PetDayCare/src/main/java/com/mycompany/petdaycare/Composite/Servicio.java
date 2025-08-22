package com.mycompany.petdaycare.Composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;
import com.mycompany.petdaycare.Mascota.Mascota;

public abstract class Servicio {
    protected String nombre;
    protected String descripcion;
    protected double precio;
    protected CategoriaCuidado categoria;
    protected List<Mascota> mascotas = new ArrayList<>();

    public void actualizarDetalles(String nuevoNombre, String nuevaDescripcion, double nuevoPrecio) {
        this.nombre = nuevoNombre;
        this.descripcion = nuevaDescripcion;
        this.precio = nuevoPrecio;
    }

    public List<Mascota> getMascotas() {
        return Collections.unmodifiableList(mascotas); 
    }

    public abstract void ejecutar();

    public void addMascota(Mascota mascota) {
        if (mascota == null) {
            throw new NullPointerException("La mascota no puede ser null");
        }
        mascotas.add(mascota);
    }

    public void removeMascota(Mascota mascota) {
        if (mascota == null) {
            throw new NullPointerException("La mascota no puede ser null");
        }
        mascotas.remove(mascota);
    }

    public double getPrecio() { return precio; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public CategoriaCuidado getCategoria() { return categoria; }

    public void setCategoria(CategoriaCuidado categoria) { this.categoria = categoria; }
    public void setMascotas(List<Mascota> mascotas) { this.mascotas = mascotas; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(double precio) { this.precio = precio; }
}
