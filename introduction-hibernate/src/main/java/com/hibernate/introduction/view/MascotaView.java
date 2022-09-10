package com.hibernate.introduction.view;

import java.util.List;

import javax.swing.JOptionPane;

import com.hibernate.introduction.controller.MascotaController;

public class MascotaView {
    
    private MascotaController controlador;

    public MascotaView(){
        controlador = new MascotaController();
    }

    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
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
            mostrarMensaje("Mascota registrada con exito");
            
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Por favor intete mas tarde");
        }
    }

    public void consultarMascotaXid() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese el identificador de la mascota"));
        try {
            String info = controlador.readById(id);
            mostrarMensaje(info);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Por favor intete mas tarde");
        }
    }

    public void consultarMascotasXapellido(){
        String apellido = JOptionPane.showInputDialog(null, "Por favor ingrese el apellido");
        try {
            List<String> mascotas = controlador.getByLastname(apellido);
            String info = "--------------MASCOTAS--------------\n";
            for(int i = 0; i < mascotas.size(); i++){
                info += mascotas.get(i);
            }
            mostrarMensaje(info);
        } catch (Exception e) {
            e.printStackTrace();
            mostrarMensaje("Por favor intente mas tarde");
        }
    }
}
