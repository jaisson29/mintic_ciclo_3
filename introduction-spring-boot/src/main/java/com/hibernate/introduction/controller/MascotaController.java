package com.hibernate.introduction.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.introduction.model.Mascota;


@RestController
@RequestMapping("/mascotas")
public class MascotaController {
    //ATRIBUTOS
    SessionFactory factory;

    public MascotaController(){
        // Crear objeto fabricante de sesiones
        factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Mascota.class)
        .buildSessionFactory();
    }
    
    /* @GetMapping
    public String holaMundo(){
    return "Hola mundo utilizando Spring Boot";
    } */

    public Session createSession(){
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    @GetMapping
    public List<Mascota> getList() throws Exception{
        Session session = factory.openSession();
        session.beginTransaction();
        List<Mascota> mascotas = session.createQuery("FROM Mascota", Mascota.class).list();
        session.close();
        return mascotas;
    }

    @GetMapping("/{id}")
    public Mascota readById(@PathVariable(name = "id")int id) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Mascota mascota = session.find(Mascota.class, id);
        session.close();
        return mascota;
    }

    @GetMapping("/fullname")
    public List<Mascota> getByLastname(@RequestParam String nombre, @RequestParam String apellido) throws Exception {
        // List<String> mascotas = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Mascota> objMascotas = session.createQuery("FROM Mascota WHERE nombre = :n AND apellido = :ap", Mascota.class)
        .setParameter("n", nombre)
        .setParameter("ap", apellido).list();
        session.close();
        return objMascotas;
        // return mascotas;
    }


    @PostMapping
    public String create(@RequestBody Mascota mascota) {
        String message = "";
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.persist(mascota);
            session.getTransaction().commit();
            message = "Mascota creada con exito";
        } catch (Exception e) {
            message = e.getMessage();
        }
    session.close();
    return message;
    
    }

    @PutMapping
    public void update(@RequestBody Mascota mascota) throws Exception{
        Session session = factory.openSession();
        session.beginTransaction();
        // Realizar actualizacion en la BD
        session.merge(mascota);
        session.getTransaction().commit();
        session.close();
    }
    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") int id){
        Session session = createSession();
        Mascota mascota = session.find(Mascota.class, id);
        deleteService(mascota);
        return "Mascota eliminada con exito";
    }
    
    public List<String> objToString(List<Mascota> objMascotas){
        List<String> mascotas = new ArrayList<>();
        for (int i = 0; i< objMascotas.size(); i++) {
            mascotas.add(objMascotas.get(i).toString());
        }
        return mascotas;
    }



    public void deleteService(Mascota mascota){
        Session session = createSession();
        // Eliminar
        session.remove(mascota);
        session.getTransaction().commit();
    }


}
