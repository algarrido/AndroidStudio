package es.iesfranciscodelosrios.algarrido.wolfrol.views;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import es.iesfranciscodelosrios.algarrido.wolfrol.R;
import es.iesfranciscodelosrios.algarrido.wolfrol.interfaces.ListadoInterface;
import es.iesfranciscodelosrios.algarrido.wolfrol.presenters.ListadoPresenter;

public class ListadoActivity extends AppCompatActivity implements ListadoInterface.View{
    String TAG="WolfRol/ListadoActivity";
    private ListadoInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new ListadoPresenter(this);

        FloatingActionButton fab = findViewById(R.id.listadoFb);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Pulsando boton flotante...");
                presenter.botonAñadir();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sobreMi:
                Log.i(TAG, "Sobre mi...");
                presenter.pestaña3();
                return true;
            case R.id.action_ordenar:
                Log.i(TAG, "Ordenar...");;
                return true;

            case R.id.action_settings:
                Log.i(TAG, "Configuracion...");;
                return true;
            case R.id.action_buscar:
                Log.i(TAG, "Buscar...");;
                presenter.pestañaBuscar();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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
    public void lanzarFormulario() {
        Log.d(TAG,"Lanzando Formulario...");
        Intent intent = new Intent(ListadoActivity.this, FormularioActivity.class);
        startActivity(intent);
    }

    @Override
    public void lanzarSobreMi() {
        Log.d(TAG,"Lanzando sobre mi...");
        Intent intent = new Intent(ListadoActivity.this,SobreMiActivity.class);
        startActivity(intent);
    }

    @Override
    public void lanzarBuscar() {
        Log.d(TAG,"Lanzando buscar...");
        Intent intent = new Intent(ListadoActivity.this,BuscarActivity.class);
        startActivity(intent);
    }
}
