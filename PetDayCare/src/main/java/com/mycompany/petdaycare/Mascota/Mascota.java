package com.mycompany.petdaycare.Mascota;

import com.mycompany.petdaycare.Mascota.DatosMascota.Especie;
import com.mycompany.petdaycare.Mascota.DatosMascota.Raza;

public class Mascota {
    
    private Especie especie;// Code Smell
    private Raza raza;// Code Smell
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


    public void setEspecie(Especie especie) {
        this.especie = especie;
    }


    public void setRaza(Raza raza) {
        this.raza = raza;
    }


    public void setEdad(int edad) {
        this.edad = edad;
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


}
