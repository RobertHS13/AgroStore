package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.agrostore01.CapaEntidades.DetallesUsuario;
import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;

public class PerfilUsuarioActivity extends RecieveBundlesActivity {

    private ImageButton ibMisDatos, ibClave, ibReputacion, ibConfiguracionCuenta;

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);

        recieveBundles(this);

        ibMisDatos = findViewById(R.id.ibMisDatos);
        ibConfiguracionCuenta = findViewById(R.id.ibConfiguracionCuenta);
        ibReputacion = findViewById(R.id.ibReputacion);
        ibClave = findViewById(R.id.ibClave);

        ibMisDatos.setOnClickListener(ibMisDatosListener);
        ibConfiguracionCuenta.setOnClickListener(ibConfiguracionCuentaListener);
        ibClave.setOnClickListener(ibClaveListener);
        ibReputacion.setOnClickListener(ibReputacionListener);
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }

    private final View.OnClickListener ibMisDatosListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(PerfilUsuarioActivity.this, MisDatosActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
        }
    };

    private final View.OnClickListener ibClaveListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(PerfilUsuarioActivity.this, ClaveActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
        }
    };

    private final View.OnClickListener ibReputacionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(PerfilUsuarioActivity.this, ReputacionActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
        }
    };

    private final View.OnClickListener ibConfiguracionCuentaListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(PerfilUsuarioActivity.this, ConfigurarCuentaActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
        }
    };

    public ImageButton getIbMisDatos() {
        return ibMisDatos;
    }
    public ImageButton getIbClave() {
        return ibClave;
    }
    public ImageButton getIbReputacion() {
        return ibReputacion;
    }
    public ImageButton getIbConfiguracionCuenta() {
        return ibConfiguracionCuenta;
    }

}
