package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;

public class Vender5Activity extends RecieveBundlesActivity {

    private Button buttonPublicarVenta;

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender5);

        recieveBundles(this);

        buttonPublicarVenta = findViewById(R.id.buttonPublicarVenta);
        buttonPublicarVenta.setOnClickListener(buttonPublicarVentaOnClickListener);
    }

    private final View.OnClickListener buttonPublicarVentaOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Vender5Activity.this, BarraActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
            finish();
        }
    };

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }

}
