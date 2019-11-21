package es.iesfranciscodelosrios.algarrido.wolfrol.presenters;


import android.util.Log;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

import es.iesfranciscodelosrios.algarrido.wolfrol.interfaces.FormularioInterface;

public class FormularioPresenter implements FormularioInterface.Presenter {

    private FormularioInterface.View view;

    public FormularioPresenter(FormularioInterface.View view) {
        this.view = view;
    }

    public interface Callback {
        public void onOk();

        public void onError(String errMsg);
    }

    @Override
    public void botonVolver() {
        view.volverListado();

    }


    @Override
    public void guardarFormulario(Callback callback) {
        //Simular logica guardado ok y ko
        double a = Math.random();
        if (a >= 0.5) {
            callback.onError("Error...");
        } else {
            callback.onOk();
        }
    }

    @Override
    public void eliminarFormulario() {

    }

    public static final String REGEX_LETRAS = "[a-zA-Z]";
    public static final String REGEX_FECHA = "^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$";

    @Override
    public void validacionCampo(boolean hasFocus, TextInputLayout nombreInputLayout, TextInputEditText n, EditText e) {
        Pattern patron = Pattern.compile(REGEX_LETRAS);
        Pattern patron2 = Pattern.compile(REGEX_FECHA);

        String stCampoLetra = n.getText().toString().trim();
        String stCampoFecha = n.getText().toString().trim();
        if (!hasFocus) {
            Log.d("AppCRUD", n.getText().toString());
            if (patron.matcher(stCampoLetra).matches()) {
                nombreInputLayout.setError("Edad inválida");

            } else {
                nombreInputLayout.setError("");
            }
            if (!hasFocus) {
                Log.d("AppCRUD", e.getText().toString());
                if (patron2.matcher(stCampoFecha).matches()) {
                    e.setError("Fecha inválida");

                } else {
                    e.setError("");
                }
            }
        }
    }
}