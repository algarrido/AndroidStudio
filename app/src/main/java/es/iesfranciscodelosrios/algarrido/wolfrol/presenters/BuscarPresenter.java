package es.iesfranciscodelosrios.algarrido.wolfrol.presenters;
import es.iesfranciscodelosrios.algarrido.wolfrol.interfaces.BuscarInterface;
public class BuscarPresenter implements BuscarInterface.Presenter {

private BuscarInterface.View view;

    public BuscarPresenter(BuscarInterface.View view){
        this.view=view;
        }
@Override
    public void botonVolver() {
            view.volverListado();
            }
    }
