package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class SeguridadActivity extends RecieveBundlesActivity {

    private ImageButton ibCambiar;
    private EditText etClave, etConfirmarClave;

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad);

        recieveBundles(this);

        ibCambiar = findViewById(R.id.ibCambiar);
        etClave = findViewById(R.id.etClave);
        etConfirmarClave = findViewById(R.id.etConfirmarClave);

        ibCambiar.setOnClickListener(ibCambiarListener);
    }

    private final View.OnClickListener ibCambiarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SeguridadActivity.this, PerfilUsuarioActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
            finish();
        }
    };

    public ImageButton getIbCambiar() {
        return ibCambiar;
    }
    public EditText getEtClave() { return etClave; }
    public EditText getEtConfirmarClave() {
        return etConfirmarClave;
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }

}
