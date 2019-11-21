package es.iesfranciscodelosrios.algarrido.wolfrol.interfaces;

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
    }
}
