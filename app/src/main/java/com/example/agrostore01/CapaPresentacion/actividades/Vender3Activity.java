package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;

public class Vender3Activity extends RecieveBundlesActivity {

    private Button buttonSiguiente;

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender3);

        recieveBundles(this);

        buttonSiguiente = findViewById(R.id.buttonSiguienteVender3);
        buttonSiguiente.setOnClickListener(buttonSiguienteOnClick);
    }

    private View.OnClickListener buttonSiguienteOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Vender3Activity.this, Vender4Activity.class);
            intent.putExtra(usuario.getClassName(), usuario);
            startActivity(intent);
        }
    };

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }
}
