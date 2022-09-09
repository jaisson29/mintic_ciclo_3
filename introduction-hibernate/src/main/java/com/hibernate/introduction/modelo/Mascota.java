package com.hibernate.introduction.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mascotas")
public class Mascota {
    //ATRIBUTOS
    @Id
    private int id;
    private String nombre;
    private String apellido;
    // por si el nombre del campo de la tabla es diferente al nombre del atributo
    // @Column(name = "tipo_mascota")
    // private String tipoMascota;
    private String tipo_mascota;
    private String raza;
    private int edad;
    private String observacion;
    //CONSTRUCTORES
    public Mascota(){

    }

    public Mascota(String nombre, String apellido, String tipo_mascota, String raza, int edad, String observacion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipo_mascota = tipo_mascota;
        this.raza = raza;
        this.edad = edad;
        this.observacion = observacion;
    }
    

    //CONSULTORES
    //GETTERS
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getTipo_mascota(){
        return tipo_mascota;
    }
    public String getRaza(){
        return raza;
    }
    public int getEdad(){
        return edad;
    }
    public String getObservacion(){
        return observacion;
    }

    //MODIFICADORES
    //SETTERS
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setTipo_mascota(String tipo_mascota){
        this.tipo_mascota = tipo_mascota;
    }
    public void setRaza(String raza){
        this.raza = raza;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setObservacion(String observacion){
        this.observacion = observacion;
    }
}
