package com.example.agrostore01.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.agrostore01.R;

public class Vender5Activity extends AppCompatActivity {

    private Button buttonPublicarVenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender5);

        buttonPublicarVenta = findViewById(R.id.buttonPublicarVenta);
        buttonPublicarVenta.setOnClickListener(buttonPublicarVentaOnClickListener);
    }

    private final View.OnClickListener buttonPublicarVentaOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Vender5Activity.this, BarraActivity.class);
            startActivity(intent);
            finish();
        }
    };

}
