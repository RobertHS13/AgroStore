package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.agrostore01.R;

public class DetallesProductoActivity<v> extends AppCompatActivity {

    private Button buttonDetallesProductos;
    private ListView detallesProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_producto);

        //buttonDetallesProductos = findViewById(R.id.buttonDetallesProductos);
        //buttonDetallesProductos.setOnClickListener(buttonDetallesProductosListener);

        Object[] items = new Object[] {1, 2};
        //ListView detallesProductos = new ListView();
        detallesProductos = findViewById(R.id.listViewBuscar);
        //detallesProductos.setAdapter(detallesProductos);
    }

    private final View.OnClickListener buttonDetallesComprasListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), DetallesProductoActivity.class);
            startActivity(intent);
        }
    };
}
