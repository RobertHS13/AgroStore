package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.EditText;


import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;

public class AgregarTerrenoActivity extends RecieveBundlesActivity {

    private ImageButton ibAceptar;
    private Spinner sTipoTerreno;
    private EditText etNombre, etTamano, etMedidasAncho, etMedidasAlto;

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_terreno);

        ibAceptar = findViewById(R.id.ibAceptar);
        sTipoTerreno = findViewById(R.id.sTipoTerreno);
        etNombre = findViewById(R.id.tvNombre);
        etTamano = findViewById(R.id.etTamano);
        etMedidasAncho = findViewById(R.id.etMedidasAn);
        etMedidasAlto = findViewById(R.id.etMedidasAl);

        String[] datos = new String[] {"Suelo arenoso", "Suelo calizo", "Suelo limoso", "Suelo humífero", "Suelo arcilloso", "Suelo pedregoso", "Suelo de turba", "Suelo salino"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_spinner, datos);
        sTipoTerreno.setAdapter(adapter);

        ibAceptar.setOnClickListener(ibAceptarListener);

        recieveBundles(this);
    }

    private final View.OnClickListener ibAceptarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(AgregarTerrenoActivity.this, MiTerrenoActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
            finish();
        }
    };

    public ImageButton getIbAceptar() {
        return ibAceptar;
    }
    public Spinner getsTipoTerreno() {
        return sTipoTerreno;
    }
    public EditText getEtNombre() {
        return etNombre;
    }
    public EditText getEtTamano() {
        return etTamano;
    }
    public EditText getEtMedidasAncho() { return etMedidasAncho; }
    public EditText getEtMedidasAlto() {
        return etMedidasAlto;
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }

}
