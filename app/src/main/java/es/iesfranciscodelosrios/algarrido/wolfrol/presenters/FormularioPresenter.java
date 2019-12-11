package es.iesfranciscodelosrios.algarrido.wolfrol.presenters;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.regex.Pattern;

import es.iesfranciscodelosrios.algarrido.wolfrol.R;
import es.iesfranciscodelosrios.algarrido.wolfrol.interfaces.FormularioInterface;
import es.iesfranciscodelosrios.algarrido.wolfrol.views.FormularioActivity;

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
           // Snackbar.make((View) view, "Permiso denegado", Snackbar.LENGTH_LONG)
              //      .show();

        }else{
            //Snackbar.make((View) view, "Permiso aceptado ", Snackbar.LENGTH_LONG)
              //     .show();
            view.selectPicture();
        }
    }

    @Override
    public void resultPermission(int result) {
            if (result == PackageManager.PERMISSION_GRANTED) {
                // Permiso aceptado
                Log.d(TAG,"Permiso aceptado");
                view.selectPicture();
               // Snackbar.make((View) view, "Permiso aceptado", Snackbar.LENGTH_LONG)
                  //      .show();

            } else {
                // Permiso rechazado
                Log.d(TAG,"Permiso denegado");
                view.requestPermision();
                 //Snackbar.make((View) view, "Permiso denegado", Snackbar.LENGTH_LONG)
                   //    .show();


            }
    }

}


























