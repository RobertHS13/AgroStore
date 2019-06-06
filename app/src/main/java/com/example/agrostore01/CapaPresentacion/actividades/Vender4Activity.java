package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;

public class Vender4Activity extends RecieveBundlesActivity {

    private Spinner spinnerClasificacion;
    private Spinner spinnerUnidad;
    private Button buttonSiguiente;

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender4);

        recieveBundles(this);

        // Spinner de clasificacion de producto
        spinnerClasificacion = findViewById(R.id.spinnerClasificacion);
        ArrayAdapter<CharSequence> adapterClasificacion = ArrayAdapter.createFromResource(
                this,
                R.array.clasificacion_productos_semillas,
                android.R.layout.simple_spinner_item
        );
        adapterClasificacion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClasificacion.setAdapter(adapterClasificacion);

        // Spinner de unidades
        spinnerUnidad = findViewById(R.id.spinnerUnidad);
        ArrayAdapter<CharSequence> adapterUnidad = ArrayAdapter.createFromResource(
                this,
                R.array.unidades,
                android.R.layout.simple_spinner_item
        );
        adapterUnidad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUnidad.setAdapter(adapterClasificacion);

        buttonSiguiente = findViewById(R.id.buttonSiguienteVender4);
        buttonSiguiente.setOnClickListener(buttonSiguienteOnClick);
    }

    private View.OnClickListener buttonSiguienteOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Vender4Activity.this, Vender5Activity.class);
            startActivity(intent);
        }
    };

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }
}
