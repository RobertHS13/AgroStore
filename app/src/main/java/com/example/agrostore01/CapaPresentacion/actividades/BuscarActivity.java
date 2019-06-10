package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.CapaEntidades.vistas.VistaBusquedaProducto;
import com.example.agrostore01.CapaNegocios.lectores.LectorProducto;
import com.example.agrostore01.CapaNegocios.lectores.vistas.LectorVistaBusquedaProducto;
import com.example.agrostore01.R;
import com.example.agrostore01.CapaPresentacion.adaptadores.BusquedaAdapter;

import java.util.ArrayList;
import java.util.List;

public class BuscarActivity extends RecieveBundlesActivity {

    private SearchView buscador;
    private Button buttonFiltrar;
    private ListView listViewBuscar;

    private Usuario usuario = new Usuario();

    // Variables de tipoBusqueda
    private String tipoBusqueda;
    private String filtroCategoria;
    private String filtroNombreProducto;

    // Productos buscados
    private List<Integer> idProductos;
    private List<VistaBusquedaProducto> vistasProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        recieveBundles(this);

        buscador = findViewById(R.id.searchViewBuscador);
        buscador.setOnQueryTextListener(buscadorListener);

        buttonFiltrar = findViewById(R.id.buttonFiltrar);
        buttonFiltrar.setOnClickListener(buttonFiltrarListener);

        listViewBuscar = findViewById(R.id.listViewBuscar);
        listViewBuscar.setOnItemClickListener(listViewBuscarListener);

        new RealizarBusqueda().execute();
    }

    private final SearchView.OnQueryTextListener buscadorListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            tipoBusqueda = FiltrosActivity.BUSQUEDA_NOMBRE_PRODUCTO;
            filtroNombreProducto = query;

            new RealizarBusqueda().execute();

            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    private class RealizarBusqueda extends AsyncTask<Void, Void, Void> {

        private LectorProducto lectorProducto = new LectorProducto();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            switch (tipoBusqueda) {

                case FiltrosActivity.BUSQUEDA_CATEGORIA: {
                    System.out.println("Tipo de tipoBusqueda 'CATEGORIA' '" + filtroCategoria + "'");

                    idProductos = lectorProducto.getIdProductosConCategoria(filtroCategoria);

                    System.out.println("Se obtuvieron los siguientes productos con el filtroCategoria '" + filtroCategoria + "'");
                    System.out.println(idProductos);

                    LectorVistaBusquedaProducto lectorVistaBusquedaProducto = new LectorVistaBusquedaProducto();
                    vistasProductos = new ArrayList<>();
                    for (Integer id : idProductos) {
                        VistaBusquedaProducto producto = lectorVistaBusquedaProducto.getEntidadId(id);
                        vistasProductos.add(producto);
                    }

                    System.out.println("Las vistas para los productos son: ");
                    System.out.println(vistasProductos);

                    break;
                }

                case FiltrosActivity.BUSQUEDA_NOMBRE_PRODUCTO: {
                    System.out.println("Tipo de tipoBusqueda 'NOMBRE PRODUCTO' '" + filtroNombreProducto + "'");

                    idProductos = lectorProducto.getIdProductosConNombre(filtroNombreProducto);

                    System.out.println("Se obtuvieron los siguientes productos con el nombre '" + filtroNombreProducto + "'");
                    System.out.println(idProductos);

                    LectorVistaBusquedaProducto lectorVistaBusquedaProducto = new LectorVistaBusquedaProducto();
                    vistasProductos = new ArrayList<>();
                    for (Integer id : idProductos) {
                        VistaBusquedaProducto producto = lectorVistaBusquedaProducto.getEntidadId(id);
                        vistasProductos.add(producto);
                    }

                    System.out.println("Las vistas para los productos son: ");
                    System.out.println(vistasProductos);

                    break;
                }

                case FiltrosActivity.BUSQUEDA_FILTRO: {
                    System.out.println("Tipo de tipoBusqueda 'FILTROS'");
                    break;
                }

                default: {
                    System.out.println("Ningun tipo de tipoBusqueda detectado");
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (vistasProductos != null) {
                BusquedaAdapter adaptador = new BusquedaAdapter(BuscarActivity.this, R.layout.list_item_buscar, vistasProductos);
                listViewBuscar.setAdapter(adaptador);
            }

            System.out.println("Terminado el hilo de tipoBusqueda");
        }
    }

    private final View.OnClickListener buttonFiltrarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), FiltrosActivity.class);
            startActivity(intent);
        }
    };

    private AdapterView.OnItemClickListener listViewBuscarListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            System.out.println("Clicked item " + position);
            System.out.println("Item id is " + idProductos.get(position));
            System.out.println("Vista producto is " + vistasProductos.get(position));

            Intent intent = new Intent(view.getContext(), DetallesProductoActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);
            intent.putExtra("idProducto", idProductos.get(position));
            intent.putExtra("vistaProducto", vistasProductos.get(position));

            startActivity(intent);
        }
    };

    @Override
    public void recieveBundles(Context context) {
        Intent intent = getIntent();

        usuario = intent.getParcelableExtra(usuario.getClassName());

        if (!intent.hasExtra(FiltrosActivity.TIPO_BUSQUEDA)) {
            return;
        }

        tipoBusqueda = intent.getStringExtra(FiltrosActivity.TIPO_BUSQUEDA);

        switch (tipoBusqueda) {

            case FiltrosActivity.BUSQUEDA_CATEGORIA: {
                filtroCategoria = intent.getStringExtra(FiltrosActivity.BUSQUEDA_CATEGORIA);
                break;
            }

            case FiltrosActivity.BUSQUEDA_NOMBRE_PRODUCTO: {
                filtroNombreProducto = intent.getStringExtra(FiltrosActivity.BUSQUEDA_NOMBRE_PRODUCTO);
                break;
            }

            case FiltrosActivity.BUSQUEDA_FILTRO: {
                break;
            }

            default: {
                break;
            }
        }
    }
}
