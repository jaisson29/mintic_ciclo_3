package com.hibernate.introduction.view;

import javax.swing.JOptionPane;

import com.hibernate.introduction.controller.MascotaController;

public class MascotaView {
    
    private MascotaController controlador;

    public MascotaView(){
        controlador = new MascotaController();
    }

    public void crearMascota(){
        // Solicitar datos
        String nombre =JOptionPane.showInputDialog(null, "Ingrese nombre de la mascota");
        String apellido = JOptionPane.showInputDialog(null, "Ingrese apellido del propietario");
        String tipo_mascota = JOptionPane.showInputDialog(null, "Ingrese el tipo de mascota");
        String raza = JOptionPane.showInputDialog(null, "Raza"); 
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad de la mascota"));
        String observacion = JOptionPane.showInputDialog(null, "Observacion");

        // Enviar datos al controlador
        try {
            controlador.create(nombre, apellido, tipo_mascota, raza, edad, observacion);
            JOptionPane.showMessageDialog(null, "Mascota registrada con exito");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor intente mas tarde");
        }
    }
}
