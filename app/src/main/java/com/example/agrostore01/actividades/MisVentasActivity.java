package com.example.agrostore01.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.agrostore01.R;
import com.example.agrostore01.adaptadores.MisVentasAdapter;

public class MisVentasActivity extends AppCompatActivity {

    private ListView listViewMisVentas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_ventas);

        Object[] items = new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        MisVentasAdapter adaptador = new MisVentasAdapter(this, R.layout.list_item_mis_ventas, items);
        listViewMisVentas = findViewById(R.id.listViewMisVentas);
        listViewMisVentas.setAdapter(adaptador);
        listViewMisVentas.setOnItemClickListener(listViewMisVentasListener);
    }

    private AdapterView.OnItemClickListener listViewMisVentasListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MisVentasActivity.this, EstadoVentaActivity.class);
            startActivity(intent);
        }
    };

}
