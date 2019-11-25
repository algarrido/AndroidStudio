package es.iesfranciscodelosrios.algarrido.wolfrol.interfaces;

import java.util.ArrayList;

import es.iesfranciscodelosrios.algarrido.wolfrol.models.Personaje;

public interface ListadoInterface {

    public interface View{

        void lanzarFormulario();
        void lanzarSobreMi();
        void lanzarBuscar();
    }

    public interface Presenter{
        void botonAñadir();
        void pestaña3();
        void pestañaBuscar();
        ArrayList<Personaje> getAllPersonaje();
    }
}
