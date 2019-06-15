package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.agrostore01.CapaEntidades.Terreno;
import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.CapaNegocios.lectores.LectorTerreno;
import com.example.agrostore01.R;
import com.example.agrostore01.CapaPresentacion.adaptadores.TerrenoAdapter;

import java.util.ArrayList;
import java.util.List;

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

        ibAgregarTerreno.setOnClickListener(ibAgregarTerrenoListener);

        new ObtenerMisTerrenos().execute();
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }

    private class ObtenerMisTerrenos extends AsyncTask<Void, Void, Void> {

        private LectorTerreno lectorTerreno = new LectorTerreno();
        private List<Terreno> terrenos = new ArrayList<>();
        private boolean exito;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            terrenos = lectorTerreno.getMisTerrenos(usuario.getIdUsuario());

            exito = terrenos != null;

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (!exito) {
                Toast.makeText(
                        MiTerrenoActivity.this,
                        "Comprueba tu conexion a Internet e intentalo de nuevo",
                        Toast.LENGTH_LONG
                ).show();
                return;
            }

            TerrenoAdapter adaptador = new TerrenoAdapter(MiTerrenoActivity.this, R.layout.list_item_terreno, terrenos);
            listViewTerrenos.setAdapter(adaptador);
        }
    }

    private final View.OnClickListener ibAgregarTerrenoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MiTerrenoActivity.this, AgregarTerrenoActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
        }
    };

}
