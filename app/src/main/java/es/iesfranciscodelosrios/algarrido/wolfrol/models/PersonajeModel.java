package es.iesfranciscodelosrios.algarrido.wolfrol.models;

import android.util.Log;

import java.util.ArrayList;

public class PersonajeModel {

    public PersonajeModel() {
    }
    public ArrayList<Personaje> getAllPersonaje(){

        ArrayList<Personaje> list=new ArrayList<Personaje>();
        Personaje personaje= new Personaje();

        personaje.setId(1);
        personaje.setNombre("Liz");
        personaje.setHistoria("iafjoiaavuneuyrgnuvyhbuabnuavbuavbayuvbayubaudvbauvbabavuyabuabvuavbuavybavybdvybydbyudbybdybsuybvsbsuvbusvbuvsfjofaiofa");

        list.add(personaje);
        //---------------------------------------------
        Personaje personaje2= new Personaje();
        personaje2.setId(2);
        personaje2.setNombre("Ana");
        personaje2.setHistoria("aicniuvnuenunosoabinobinonin aind 9und 9una9 nua9 n9auFNCIMVW9N9WNB9SVOMVOWMBIBUBNBUG SVG SYSGSBNSBN7SBNS7Buhbub");

        list.add(personaje2);
        Personaje personaje3= new Personaje();
        personaje3.setId(3);
        personaje3.setNombre("Ana");
        personaje3.setHistoria("aicniuvnuenunosoabinobinonin aind 9und 9una9 nua9 n9auFNCIMVW9N9WNB9SVOMVOWMBIBUBNBUG SVG SYSGSBNSBN7SBNS7Buhbub");

        list.add(personaje3);
        Personaje personaje4= new Personaje();
        personaje4.setId(4);
        personaje4.setNombre("Ana");
        personaje4.setHistoria("aicniuvnuenunosoabinobinonin aind 9und 9una9 nua9 n9auFNCIMVW9N9WNB9SVOMVOWMBIBUBNBUG SVG SYSGSBNSBN7SBNS7Buhbub");

        list.add(personaje4);
        return list;
    }
}
