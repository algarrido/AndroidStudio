package es.iesfranciscodelosrios.algarrido.wolfrol.presenters;

import es.iesfranciscodelosrios.algarrido.wolfrol.interfaces.ListadoInterface;

public class ListadoPresenter implements ListadoInterface.Presenter {

    private ListadoInterface.View view;

    public ListadoPresenter(ListadoInterface.View view){
        this.view=view;
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
}
