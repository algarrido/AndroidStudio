package es.iesfranciscodelosrios.algarrido.wolfrol.presenters;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.EditText;

import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

import es.iesfranciscodelosrios.algarrido.wolfrol.interfaces.FormularioInterface;

public class FormularioPresenter implements FormularioInterface.Presenter {

    private FormularioInterface.View view;
    String TAG="WolfRol/FormularioPresenter";
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

    public static final String REGEX_LETRAS = "[A-Za-z]*";
    public static final String REGEX_FECHA = "^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$";


    @Override
    public void validacionCampoPeso(boolean hasFocus, TextInputLayout nombreInputLayout, TextInputEditText n) {
        Pattern patron = Pattern.compile(REGEX_LETRAS);

        String stCampoLetra = n.getText().toString().trim();

        if (!hasFocus) {
            Log.d("AppCRUD", n.getText().toString());
            if (patron.matcher(stCampoLetra).matches()) {
                nombreInputLayout.setError("Peso inválido");

            } else {
                nombreInputLayout.setError("");
            }

        }
    }

    @Override
    public void validacionCampoFecha(boolean hasFocus, EditText editText) {

        Pattern patron2 = Pattern.compile(REGEX_FECHA);
        String stCampoLetra = editText.getText().toString().trim();

        if (!hasFocus) {
            Log.d("AppCRUD", editText.getText().toString());

                if (patron2.matcher(stCampoLetra).matches()) {
                    Log.d(TAG, "Campo fecha correcto");

                } else {
                    editText.setError("Introduzca éste formato: DD/MM/YYYY");
                }
        }
    }

    @Override
    public void onClickImage(Context c) {
        int ReadPermission = ContextCompat.checkSelfPermission(c, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (ReadPermission != PackageManager.PERMISSION_GRANTED) {
            // Permiso denegado
            view.requestPermision();

        }else{
            //view.lauchGallery();
        }
    }

    @Override
    public void resultPermission(int result) {
        if (result == PackageManager.PERMISSION_GRANTED) {
            // Permiso aceptado
            Log.d(TAG,"Permiso aceptado");
           // view.lauckgalery();

        } else {
            // Permiso rechazado
            Log.d(TAG,"Permiso denegado");
            //view.showSnackBar("Sin permisos no puedes entrar") con snavbar
        }
    }

}


























