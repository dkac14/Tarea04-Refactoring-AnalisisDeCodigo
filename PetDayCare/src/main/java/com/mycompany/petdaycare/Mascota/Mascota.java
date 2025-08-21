package com.mycompany.petdaycare.Mascota;

public class Mascota {
    
    private String especie;
    private String raza;
    private int edad;
    private double tamano;
    private String necesidades;
    private String preferenciasTrato;


    public Mascota(String especie, String raza, int edad, double tamano, String necesidades, String preferenciasTrato) {
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.tamano = tamano;
        this.necesidades = necesidades;
        this.preferenciasTrato = preferenciasTrato;
    }


    public String getEspecie() {
        return especie;
    }


    public String getRaza() {
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


    public void setEspecie(String especie) {
        this.especie = especie;
    }


    public void setRaza(String raza) {
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
