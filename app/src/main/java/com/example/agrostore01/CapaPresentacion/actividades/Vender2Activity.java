package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.agrostore01.R;

public class Vender2Activity extends AppCompatActivity {

    private ImageView imageViewPrimavera;
    private ImageView imageViewVerano;
    private ImageView imageViewOtonio;
    private ImageView imageViewInvierno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender2);

        imageViewPrimavera = findViewById(R.id.imageViewTemporadaPrimavera);
        imageViewVerano = findViewById(R.id.imageViewTemporadaVerano);
        imageViewOtonio = findViewById(R.id.imageViewTemporadaOtonio);
        imageViewInvierno = findViewById(R.id.imageViewTemporadaInvierno);

        imageViewPrimavera.setOnClickListener(imageViewTemporadaOnClick);
        imageViewVerano.setOnClickListener(imageViewTemporadaOnClick);
        imageViewOtonio.setOnClickListener(imageViewTemporadaOnClick);
        imageViewInvierno.setOnClickListener(imageViewTemporadaOnClick);
    }

    private final View.OnClickListener imageViewTemporadaOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Vender2Activity.this, Vender3Activity.class);
            startActivity(intent);
        }
    };
}
