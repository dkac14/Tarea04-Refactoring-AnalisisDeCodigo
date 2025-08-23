/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petdaycare.Observer;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Notificador {
    private List<UsuarioCliente> usuarios = new ArrayList<>();
    private String estado;
   

    public void agregarUsuario(UsuarioCliente u) {
        usuarios.add(u);
    }

    public void eliminarUsuario(UsuarioCliente u) {
        usuarios.remove(u);
    }

    public void notificarUsuario() {
        for (UsuarioCliente usuario : usuarios) {
            usuario.update(estado);
        }
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
