package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;

public class CompraActivity extends RecieveBundlesActivity {

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

        recieveBundles(this);
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }
}
