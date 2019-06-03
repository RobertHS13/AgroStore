package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.agrostore01.R;

public class Vender1Activity extends AppCompatActivity {

    private ImageView imageViewLacteos;
    private ImageView imageViewCarnes;
    private ImageView imageViewHoritalizas;
    private ImageView imageViewSemillas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender1);

        imageViewCarnes = findViewById(R.id.imageViewCategoriaCarnes);
        imageViewLacteos = findViewById(R.id.imageViewCategoriaLacteos);
        imageViewHoritalizas = findViewById(R.id.imageViewCategoriaHortalizas);
        imageViewSemillas = findViewById(R.id.imageViewCategoriaSemillas);

        imageViewCarnes.setOnClickListener(imageViewCategoriaOnClick);
        imageViewLacteos.setOnClickListener(imageViewCategoriaOnClick);
        imageViewHoritalizas.setOnClickListener(imageViewCategoriaOnClick);
        imageViewSemillas.setOnClickListener(imageViewCategoriaOnClick);
    }

    private final View.OnClickListener imageViewCategoriaOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Vender1Activity.this, Vender2Activity.class);
            startActivity(intent);
        }
    };
}
