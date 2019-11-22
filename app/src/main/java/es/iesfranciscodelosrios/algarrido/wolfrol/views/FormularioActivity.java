package es.iesfranciscodelosrios.algarrido.wolfrol.views;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

import es.iesfranciscodelosrios.algarrido.wolfrol.R;
import es.iesfranciscodelosrios.algarrido.wolfrol.interfaces.FormularioInterface;
import es.iesfranciscodelosrios.algarrido.wolfrol.presenters.FormularioPresenter;

public class FormularioActivity extends AppCompatActivity implements FormularioInterface.View{
    String TAG="WolfRol/FormularioActivity";
    private FormularioInterface.Presenter presenter;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private FloatingActionButton button;
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

    TextInputLayout pesoInputLayout;
    final Context context = this;
    FloatingActionButton delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new FormularioPresenter(this);
        presenter.botonVolver();
//-----------------------------------VALIDACION DE CAMPOS-----------------------------------------
        pesoInputLayout = (TextInputLayout) findViewById(R.id.TextPeso);
        final TextInputEditText p = (TextInputEditText) findViewById(R.id.peso);


        p.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                presenter.validacionCampoPeso(hasFocus, pesoInputLayout, p);
            }
        });
        final EditText f = (EditText) findViewById(R.id.editTextFechaF);
        f.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                presenter.validacionCampoFecha(hasFocus,f);
            }
        });

        // Definición de la lista de opciones------------------------------------
        ArrayList<String> items = new ArrayList<String>();
        items.add("Elfo");
        items.add("Orco");
        items.add("Semi Elfo");
        items.add("Humano");

        // Definición del Adaptador que contiene la lista de opciones
        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        // Definición del Spinner
        spinner = (Spinner) findViewById(R.id.spinnerRaza);
        spinner.setAdapter(adapter);

        // Definición de la acción del botón
        button = (FloatingActionButton) findViewById(R.id.floatingActionButtonAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Recuperación de la vista del AlertDialog a partir del layout de la Actividad
                LayoutInflater layoutActivity = LayoutInflater.from(context);
                View viewAlertDialog = layoutActivity.inflate(R.layout.alert_dialog, null);

                // Definición del AlertDialog
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

                // Asignación del AlertDialog a su vista
                alertDialog.setView(viewAlertDialog);

                // Recuperación del EditText del AlertDialog
                final EditText dialogInput = (EditText) viewAlertDialog.findViewById(R.id.dialogInput);

                // Configuración del AlertDialog
                alertDialog
                        .setCancelable(false)
                        // Botón Añadir
                        .setPositiveButton(getResources().getString(R.string.add),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        adapter.add(dialogInput.getText().toString());
                                        spinner.setSelection(adapter.getPosition(dialogInput.getText().toString()));
                                    }
                                })
                        // Botón Cancelar
                        .setNegativeButton(getResources().getString(R.string.cancel),
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                })
                        .create()
                .show();
            }
        });


        //----------------------DECLARACION PARA LA FECHA-----------------------------------------------
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

//--------------------------------------------BOTON GUARDAR-------------------------------------------
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


        //------------------------------BOTON ELIMINAR---------------------------------------------------
        FloatingActionButton btn = findViewById(R.id.floatingActionButtonEliminar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vieww) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(FormularioActivity.this);
                dialog.setTitle(R.string.Borrado);
                dialog.setMessage(R.string.mensaje);
                dialog.setCancelable(true);

                dialog.setPositiveButton(
                        "Sí",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int
                                    id) {
                                presenter.guardarFormulario(new FormularioPresenter.Callback() {
                                    @Override
                                    public void onOk() {
                                        Toast.makeText(FormularioActivity.this, "Eliminando...", Toast.LENGTH_SHORT).show(); //Correcto
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
                dialog.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = dialog.create();
                alert.show();
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

