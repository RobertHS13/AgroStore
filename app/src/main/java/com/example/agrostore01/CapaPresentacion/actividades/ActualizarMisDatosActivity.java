package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;

import com.example.agrostore01.CapaEntidades.DetallesUsuario;
import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;

public class ActualizarMisDatosActivity extends RecieveBundlesActivity {

    private EditText etNombre, etUsuario, etEmail, etTelefono, etDireccion;
    private ImageButton ibGuardar;

    private Usuario usuario = new Usuario();
    private DetallesUsuario detallesUsuario = new DetallesUsuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_mis_datos);

        recieveBundles(this);

        ibGuardar = findViewById(R.id.ibGuardar);
        etNombre = findViewById(R.id.tvNombre);
        etUsuario = findViewById(R.id.tvUsuario);
        etEmail = findViewById(R.id.tvEmail);
        etTelefono = findViewById(R.id.tvTelefono);
        etDireccion = findViewById(R.id.tvDireccion);
        ibGuardar.setOnClickListener(ibGuardarListener);
    }

    private final View.OnClickListener ibGuardarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ActualizarMisDatosActivity.this, MisDatosActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);
            intent.putExtra(detallesUsuario.getClassName(), detallesUsuario);

            startActivity(intent);
            finish();
        }
    };

    public EditText getEtNombre() {
        return etNombre;
    }
    public EditText getEtUsuario() {
        return etUsuario;
    }
    public EditText getEtEmail() {
        return etEmail;
    }
    public EditText getEtTelefono() {
        return etTelefono;
    }
    public EditText getEtDireccion() { return etDireccion; }
    public ImageButton getIbGuardar() {
        return ibGuardar;
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
        detallesUsuario = getIntent().getParcelableExtra(detallesUsuario.getClassName());
    }

}
