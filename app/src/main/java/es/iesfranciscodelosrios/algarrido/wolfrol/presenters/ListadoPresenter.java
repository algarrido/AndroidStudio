package es.iesfranciscodelosrios.algarrido.wolfrol.presenters;

import java.util.ArrayList;

import es.iesfranciscodelosrios.algarrido.wolfrol.interfaces.ListadoInterface;
import es.iesfranciscodelosrios.algarrido.wolfrol.models.Personaje;
import es.iesfranciscodelosrios.algarrido.wolfrol.models.PersonajeModel;

public class ListadoPresenter implements ListadoInterface.Presenter {

    private ListadoInterface.View view;
    private PersonajeModel personaje;

    public ListadoPresenter(ListadoInterface.View view){
        this.view=view;
        this.personaje=new PersonajeModel();
    }
    @Override
    public void botonAñadir() {
        view.lanzarFormulario();
    }
    @Override
    public void pestaña3() {
        view.lanzarSobreMi();
    }

    @Override
    public void pestañaBuscar() {
        view.lanzarBuscar();
    }

    @Override
    public ArrayList<Personaje>getAllPersonaje(){
        return personaje.getAllPersonaje();
    }
}
