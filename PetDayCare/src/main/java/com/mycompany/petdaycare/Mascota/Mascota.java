package com.mycompany.petdaycare.Mascota;

import com.mycompany.petdaycare.Mascota.DatosMascota.Especie;
import com.mycompany.petdaycare.Mascota.DatosMascota.Raza;

public class Mascota {
    
    private final Especie especie;
    private final Raza raza;
    private int edad;
    private double tamano;
    private String necesidades;
    private String preferenciasTrato;


    public Mascota(Especie especie, Raza raza, int edad, double tamano, String necesidades, String preferenciasTrato) {
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.tamano = tamano;
        this.necesidades = necesidades;
        this.preferenciasTrato = preferenciasTrato;
    }


    public Especie getEspecie() {
        return especie;
    }


    public Raza getRaza() {
        return raza;
    }


    public int getEdad() {
        return edad;
    }


    public double getTamano() {
        return tamano;
    }


    public String getNecesidades() {
        return necesidades;
    }


    public String getPreferenciasTrato() {
        return preferenciasTrato;
    }



    public void cumplirAnios() {
        this.edad++;
    }


    public void setTamano(double tamano) {
        this.tamano = tamano;
    }


    public void setNecesidades(String necesidades) {
        this.necesidades = necesidades;
    }


    public void setPreferenciasTrato(String preferenciasTrato) {
        this.preferenciasTrato = preferenciasTrato;
    }

    public boolean esCachorro() {
        return edad < 2;
    }

    public boolean esDeRazaGrande() {
        return tamano > 25.0;
    }

}
