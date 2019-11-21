package es.iesfranciscodelosrios.algarrido.wolfrol.interfaces;

import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import es.iesfranciscodelosrios.algarrido.wolfrol.presenters.FormularioPresenter;

public interface FormularioInterface {
    public interface View{
        void volverListado();

    }

    public interface Presenter{
        void botonVolver();
        void guardarFormulario(FormularioPresenter.Callback callback);
        void eliminarFormulario();
        void validacionCampoPeso(boolean hasFocus, TextInputLayout nombreInputLayout, TextInputEditText n);
        void validacionCampoFecha(boolean hasFocus,EditText editText);
    }
}
