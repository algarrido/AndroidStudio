package es.iesfranciscodelosrios.algarrido.wolfrol.models;

import android.util.Log;

import java.util.Date;
import java.util.regex.Pattern;

public class Personaje {

    String TAG = "WolfRol/Personaje";

    public static final String REGEX_LETRAS = "[A-Za-z]*";
    public static final String REGEX_HIS = "\\w*";

    private Integer id;
    private String imagen = null;
    private String nombre = null;
    private String historia = null;
    private String peso = null;
    private String fecha = null;
    private String genero;
    private String raza;
    private String partida;

    public Personaje() {

    }

    public String isPartida() {
        return partida;
    }

    public void setPartida(String partida) {

        this.partida = partida;

    }

    public String getFecha() {
        return fecha;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPeso() {
        return peso;
    }

    public boolean setFecha(String fecha) {
        this.fecha = fecha;
        return true;
    }

    public boolean setPeso(String peso) {

        Pattern patron = Pattern.compile(REGEX_LETRAS);
        String stCampoLetra = peso.toString().trim();
           if (patron.matcher(stCampoLetra).matches() || peso.isEmpty()) {
             Log.d(TAG, "Campo peso incorrecto");
           return false;
         } else {
        this.peso = peso;
          Log.d(TAG, "Campo peso correcto");
        return true;
        }

    }

    public String getGenero() {
        return genero;
    }

    public boolean setGenero(String genero) {
        Pattern patron = Pattern.compile(REGEX_LETRAS);
        String stCampoLetra = genero.toString().trim();
        if (patron.matcher(stCampoLetra).matches() || genero.isEmpty()) { //expresion regular- todos los set
            this.genero = genero;
            Log.d(TAG, "Campo genero correcto");
            return true;
        } else {
            Log.d(TAG, "Campo genero incorrecto");
            return false;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public boolean setImagen(String imagen) {
        if (!imagen.isEmpty()) {
            this.imagen = imagen;
            return true;
        } else {
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        if (!nombre.isEmpty()) {
            this.nombre = nombre;
            return true;
        } else {
            return false;
        }
    }

    public String getHistoria() {
        return historia;
    }

    public boolean setHistoria(String historia) {
        if (!historia.isEmpty()) {
            this.historia = historia;
            return true;
        } else {
            return false;
        }

    }
}
