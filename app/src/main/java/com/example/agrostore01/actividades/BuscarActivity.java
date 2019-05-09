package com.example.agrostore01.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.agrostore01.R;
import com.example.agrostore01.adaptadores.BusquedaAdapter;

public class BuscarActivity extends AppCompatActivity {

    private Button buttonFiltrar;
    private ListView listViewBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        buttonFiltrar = findViewById(R.id.buttonFiltrar);
        buttonFiltrar.setOnClickListener(buttonFiltrarListener);

        Object[] items = new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BusquedaAdapter adaptador = new BusquedaAdapter(this, R.layout.list_item_buscar, items);
        listViewBuscar = findViewById(R.id.listViewBuscar);
        listViewBuscar.setAdapter(adaptador);
    }

    private final View.OnClickListener buttonFiltrarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), FiltrosActivity.class);
            startActivity(intent);
        }
    };

}
