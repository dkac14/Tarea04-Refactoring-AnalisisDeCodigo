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
    private List<Usuario> usuarios = new ArrayList<>();
    private String estado;

    public void agregar(Usuario u) {
        usuarios.add(u);
    }

    public void eliminarUsuario(Usuario u) {
        usuarios.remove(u);
    }

    public void notificarUsuario() {
        for (Usuario usuario : usuarios) {
            usuario.update(estado);
        }
    }
}
