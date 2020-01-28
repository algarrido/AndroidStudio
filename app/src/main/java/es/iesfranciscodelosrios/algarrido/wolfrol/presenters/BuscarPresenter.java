package es.iesfranciscodelosrios.algarrido.wolfrol.presenters;

import es.iesfranciscodelosrios.algarrido.wolfrol.interfaces.BuscarInterface;
import es.iesfranciscodelosrios.algarrido.wolfrol.models.PersonajeModel;

public class BuscarPresenter implements BuscarInterface.Presenter {

    private BuscarInterface.View view;
    private PersonajeModel personaje;

    public BuscarPresenter(BuscarInterface.View view) {
        this.view = view;
        personaje = PersonajeModel.getInstance();
    }

    @Override
    public void botonVolver() {
        view.volverListado();
    }

    @Override
    public void filtrar(String nombre, String fecha, String raza) {
        //Simular logica guardado ok y ko
        boolean guardado = true;
        if (personaje.buscar(nombre, fecha, raza)) {

        } else {

        }
    }
}


