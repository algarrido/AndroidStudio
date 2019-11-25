package es.iesfranciscodelosrios.algarrido.wolfrol.models;

import java.util.ArrayList;

public class PersonajeModel {

    public PersonajeModel() {
    }
    public ArrayList<Personaje> getAllPersonaje(){

        ArrayList<Personaje> list=new ArrayList<Personaje>();
        Personaje personaje= new Personaje();

        personaje.setId(1);
        personaje.setNombre("Liz");
        personaje.setHistoria("iafjoiafjofaiofa");

        list.add(personaje);
        //---------------------------------------------
        personaje.setId(2);
        personaje.setNombre("Liz2");
        personaje.setHistoria("iafjoiafjofaiofa2");

        list.add(personaje);
        return list;
    }
}
