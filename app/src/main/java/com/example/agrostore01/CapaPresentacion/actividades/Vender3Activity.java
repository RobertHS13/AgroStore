package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.agrostore01.R;

public class Vender3Activity extends AppCompatActivity {

    private Button buttonSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender3);

        buttonSiguiente = findViewById(R.id.buttonSiguienteVender3);
        buttonSiguiente.setOnClickListener(buttonSiguienteOnClick);
    }

    private View.OnClickListener buttonSiguienteOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Vender3Activity.this, Vender4Activity.class);
            startActivity(intent);
        }
    };
}
