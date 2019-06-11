package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.CapaEntidades.vistas.VistaMisCompras;
import com.example.agrostore01.CapaNegocios.lectores.vistas.LectorMisCompras;
import com.example.agrostore01.R;
import com.example.agrostore01.CapaPresentacion.adaptadores.MisComprasAdapter;

import java.util.ArrayList;
import java.util.List;

public class MisComprasActivity extends RecieveBundlesActivity {

    private ListView listViewMisCompras;

    private List<VistaMisCompras> misCompras = new ArrayList<>();

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_compras);

        recieveBundles(this);

        listViewMisCompras = findViewById(R.id.listViewMisCompras);
        listViewMisCompras.setOnItemClickListener(listViewMisComprasListener);

        new ObtenerMisCompras().execute();
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }

    private class ObtenerMisCompras extends AsyncTask<Void, Void, Void> {

        private LectorMisCompras lectorMisCompras = new LectorMisCompras();
        private boolean exito;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            misCompras = lectorMisCompras.getMisCompras(usuario.getIdUsuario());
            exito = misCompras != null;

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (!exito) {
                Toast.makeText(
                        MisComprasActivity.this,
                        "Hubo un error al obtener tus compras. Verifica tu conexion a Internet e intentelo de nuevo",
                        Toast.LENGTH_LONG
                ).show();
                return;
            }

            MisComprasAdapter adaptador = new MisComprasAdapter(MisComprasActivity.this, R.layout.list_item_mis_compras, misCompras);
            listViewMisCompras.setAdapter(adaptador);
        }
    }

    private AdapterView.OnItemClickListener listViewMisComprasListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MisComprasActivity.this, EstadoCompraActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
        }
    };

}
