package com.mycompany.petdaycare.Composite;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

import com.mycompany.petdaycare.CategoriaCuidado.CategoriaCuidado;
import com.mycompany.petdaycare.Mascota.Mascota;

public abstract class Servicio {
    protected CategoriaCuidado categoria;
    protected ArrayList<Mascota> mascotas = new ArrayList<>();
    protected String nombre;
    protected String descripcion;
    protected BigDecimal precio;
    protected Currency currency;

    public List<Mascota> getMascotas() {
        return Collections.unmodifiableList(mascotas);
    }
    public void addMascota(Mascota mascota) {
        mascotas.add(Objects.requireNonNull(mascota, "La mascota no puede ser null"));
    }
    public void removeMascota(Mascota mascota) {
        if (mascota == null) {
            throw new NullPointerException("La mascota no puede ser null");
        }
        mascotas.remove(mascota);
    }
    public abstract void ejecutar(); 
    public BigDecimal getPrecio() { return precio;}
    public Currency getCurrency() { return currency;}
    public String getNombre() { return nombre;}
    public String getDescripcion() { return descripcion;}
    public CategoriaCuidado getCategoria() { return categoria;}
    public void setCategoria(CategoriaCuidado categoria) { this.categoria = categoria;}
    public void setNombre(String nombre) {this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser null"); }
    public void setDescripcion(String descripcion) { this.descripcion = Objects.requireNonNull(descripcion, "La descripción no puede ser null"); }

    public void setPrecio(BigDecimal precio) { 
        this.precio = Objects.requireNonNull(precio, "El precio no puede ser null");
        if (precio.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }
    public void setCurrency(Currency currency) { 
        this.currency = Objects.requireNonNull(currency, "La moneda no puede ser null");
    }
}