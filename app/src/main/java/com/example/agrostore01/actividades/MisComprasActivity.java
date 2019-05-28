package com.example.agrostore01.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.agrostore01.R;
import com.example.agrostore01.adaptadores.MisComprasAdapter;

public class MisComprasActivity extends AppCompatActivity {

    private ListView listViewMisCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_compras);

        Object[] items = new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        MisComprasAdapter adaptador = new MisComprasAdapter(this, R.layout.list_item_mis_compras, items);
        listViewMisCompras = findViewById(R.id.listViewMisCompras);
        listViewMisCompras.setAdapter(adaptador);
        listViewMisCompras.setOnItemClickListener(listViewMisComprasListener);
    }

    private AdapterView.OnItemClickListener listViewMisComprasListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MisComprasActivity.this, EstadoCompraActivity.class);
            startActivity(intent);
        }
    };

}
