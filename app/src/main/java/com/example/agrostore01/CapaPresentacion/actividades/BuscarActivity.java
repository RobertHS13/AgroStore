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
import android.widget.Toast;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.CapaEntidades.vistas.VistaBusquedaProducto;
import com.example.agrostore01.CapaNegocios.lectores.LectorProducto;
import com.example.agrostore01.CapaNegocios.lectores.vistas.LectorVistaBusquedaProducto;
import com.example.agrostore01.R;
import com.example.agrostore01.CapaPresentacion.adaptadores.BusquedaAdapter;

import java.util.ArrayList;
import java.util.List;

public class BuscarActivity extends RecieveBundlesActivity {

    public static final String TIPO_BUSQUEDA = "Busqueda";

    public static final int TIPO_CATEGORIA = 1;
    public static final String BUSQUEDA_CATEGORIA = "BusquedaCategoria";
    public static final String BUSQUEDA_CATEGORIA_HORTALIZAS = "Hortalizas";
    public static final String BUSQUEDA_CATEGORIA_SEMILLAS = "Semillas";
    public static final String BUSQUEDA_CATEGORIA_CARNES = "Carnes";
    public static final String BUSQUEDA_CATEGORIA_LACTEOS = "Lacteos";

    public static final int TIPO_NOMBRE_PRODUCTO = 2;
    public static final String BUSQUEDA_NOMBRE_PRODUCTO = "BusquedaNombreProducto";

    public static final int TIPO_FILTROS = 3;

    private SearchView buscador;
    private Button buttonFiltrar;
    private ListView listViewBuscar;

    private Usuario usuario = new Usuario();

    private int busqueda = -1;
    private String categoria;
    private String nombreProducto;

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
            busqueda = TIPO_NOMBRE_PRODUCTO;
            nombreProducto = query;

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
        List<VistaBusquedaProducto> vistasProductos;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            switch (busqueda) {
                case -1: {
                    System.out.println("Ningun tipo de busqueda detectado (-1)");
                    break;
                }

                case TIPO_CATEGORIA: {
                    System.out.println("Tipo de busqueda 'CATEGORIA' '" + categoria + "'");

                    List<Integer> idProductos = lectorProducto.getIdProductosConCategoria(categoria);

                    System.out.println("Se obtuvieron los siguientes productos con la categoria '" + categoria + "'");
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

                case TIPO_NOMBRE_PRODUCTO: {
                    System.out.println("Tipo de busqueda 'NOMBRE PRODUCTO' '" + nombreProducto + "'");

                    List<Integer> idProductos = lectorProducto.getIdProductosConNombre(nombreProducto);

                    System.out.println("Se obtuvieron los siguientes productos con el nombre '" + nombreProducto + "'");
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

                case TIPO_FILTROS: {
                    System.out.println("Tipo de busqueda 'FILTROS'");
                    break;
                }

                default: {
                    System.out.println("Ningun tipo de busqueda detectado (d)");
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

            System.out.println("Terminado el hilo de busqueda");
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
            Intent intent = new Intent(view.getContext(), DetallesProductoActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public void recieveBundles(Context context) {
        Intent intent = getIntent();

        usuario = intent.getParcelableExtra(usuario.getClassName());

        if (!intent.hasExtra(TIPO_BUSQUEDA)) {
            busqueda = -1;
            return;
        }

        busqueda = intent.getIntExtra(TIPO_BUSQUEDA, -1);

        switch (busqueda) {
            case -1: {
                return;
            }

            case TIPO_CATEGORIA: {
                categoria = intent.getStringExtra(BUSQUEDA_CATEGORIA);
                break;
            }

            case TIPO_NOMBRE_PRODUCTO: {
                nombreProducto = intent.getStringExtra(BUSQUEDA_NOMBRE_PRODUCTO);
                break;
            }

            case TIPO_FILTROS: {
                break;
            }

            default: {
                break;
            }
        }
    }
}
