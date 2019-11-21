package es.iesfranciscodelosrios.algarrido.wolfrol.views;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

import es.iesfranciscodelosrios.algarrido.wolfrol.R;
import es.iesfranciscodelosrios.algarrido.wolfrol.interfaces.FormularioInterface;
import es.iesfranciscodelosrios.algarrido.wolfrol.presenters.FormularioPresenter;

public class FormularioActivity extends AppCompatActivity implements FormularioInterface.View{
    String TAG="WolfRol/FormularioActivity";
    private FormularioInterface.Presenter presenter;


    private DatePicker u;
    private static final String CERO = "0";
    private static final String BARRA = "/";

    //Calendario para obtener fecha
    public final Calendar c = Calendar.getInstance();

    //Variables para obtener la fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    //Widgets
    EditText etFecha;
    Button ibObtenerFecha;

    TextInputLayout nombreInputLayout;
    TextInputLayout pesoInputLayout;
    TextInputLayout generoInputLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        presenter = new FormularioPresenter(this);
        presenter.botonVolver();

        nombreInputLayout = (TextInputLayout) findViewById(R.id.TextNombre);
        pesoInputLayout = (TextInputLayout) findViewById(R.id.TextPeso);
        generoInputLayout = (TextInputLayout) findViewById(R.id.TextGenero);
        //Widget EditText donde se mostrara la fecha obtenida
        etFecha = (EditText) findViewById(R.id.editTextFechaF);
        //Widget ImageButton del cual usaremos el evento clic para obtener la fecha
        ibObtenerFecha = (Button) findViewById(R.id.ButtonDatePicket);
        //Evento setOnClickListener - clic

        ibObtenerFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerFecha();
            }
        });

        FloatingActionButton fab = findViewById(R.id.floatingActionButtonGuardar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Pulsando boton flotante...");
                presenter.guardarFormulario(new FormularioPresenter.Callback() {
                    @Override
                    public void onOk() {
                        Toast.makeText(FormularioActivity.this, "Guardando el formulario...", Toast.LENGTH_SHORT).show(); //Correcto
                        Intent intent = new Intent(FormularioActivity.this, ListadoActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(String errMsg) {
                        Toast.makeText(FormularioActivity.this, errMsg, Toast.LENGTH_SHORT).show(); //error
                    }
                });
            }
        });


        final TextInputEditText p = (TextInputEditText) findViewById(R.id.peso);


        p.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                presenter.validacionCampo( hasFocus, pesoInputLayout,  p);
            }
        });
    }

    private void obtenerFecha(){
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                etFecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);

            }

        },anio, mes, dia);
        //Muestro el widget
        recogerFecha.show();

    }


    @Override
    public void volverListado() {
        Log.d(TAG,"Volviendo a Listado...");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected  void onStart(){
        super.onStart();
        Log.d(TAG,"onStart...");
    }
    @Override
    protected  void onResume(){
        super.onResume();
        Log.d(TAG,"onResume...");
    }
    @Override
    protected  void onPause(){
        super.onPause();
        Log.d(TAG,"onPause...");
    }
    @Override
    protected  void onStop(){
        super.onStop();
        Log.d(TAG,"onStop...");
    }
    @Override
    protected  void onRestart(){
        super.onRestart();
        Log.d(TAG,"onRestart...");
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy...");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG,"onBackPressed...");
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Log.d(TAG,"onSupportnavigateUp...");
        return super.onSupportNavigateUp();
    }


}

