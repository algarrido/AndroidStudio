package es.iesfranciscodelosrios.algarrido.wolfrol.interfaces;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import es.iesfranciscodelosrios.algarrido.wolfrol.presenters.FormularioPresenter;

public interface FormularioInterface {
    public interface View{
        void volverListado();
        void requestPermision();
        void selectPicture();
    }

    public interface Presenter{
        void botonVolver();
        void guardarFormulario(FormularioPresenter.Callback callback);
        void eliminarFormulario();
        void validacionCampoPeso(boolean hasFocus, TextInputLayout nombreInputLayout, TextInputEditText n);
        void validacionCampoFecha(boolean hasFocus,EditText editText);
        void onClickImage(Context c);
        void resultPermission(int result, FormularioPresenter.Callback callback);
        void galeria(ImageView i, ImageView iv, Bitmap bmp);
    }
}
