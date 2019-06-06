package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ImageButton;


import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;
import com.example.agrostore01.CapaPresentacion.adaptadores.TerrenoAdapter;

public class MiTerrenoActivity extends RecieveBundlesActivity {

    private ImageButton ibAgregarTerreno;
    private ListView listViewTerrenos;

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_terreno);

        recieveBundles(this);

        ibAgregarTerreno = findViewById(R.id.ibAgregar);
        listViewTerrenos = findViewById(R.id.listViewTerreno);

        Object[] items = new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TerrenoAdapter adaptador = new TerrenoAdapter(this, R.layout.list_item_terreno, items);
        listViewTerrenos.setAdapter(adaptador);

        ibAgregarTerreno.setOnClickListener(ibAgregarTerrenoListener);
    }

    private final View.OnClickListener ibAgregarTerrenoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MiTerrenoActivity.this, AgregarTerrenoActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
        }
    };

    public ImageButton getIbAgregarTerreno() {
        return ibAgregarTerreno;
    }
    public ListView getListViewTerrenos() {
        return listViewTerrenos;
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }

}
