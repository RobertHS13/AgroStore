package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.CapaNegocios.lectores.LectorProducto;
import com.example.agrostore01.R;
import com.example.agrostore01.CapaPresentacion.adaptadores.BusquedaAdapter;

import java.util.List;

public class BuscarActivity extends RecieveBundlesActivity {

    public static final String TIPO_BUSQUEDA = "Busqueda";

    public static final int TIPO_CATEGORIA = 1;
    public static final String BUSQUEDA_CATEGORIA = "Busqueda";
    public static final String BUSQUEDA_CATEGORIA_HORTALIZAS = "Hortalizas";
    public static final String BUSQUEDA_CATEGORIA_SEMILLAS = "Semillas";
    public static final String BUSQUEDA_CATEGORIA_CARNES = "Carnes";
    public static final String BUSQUEDA_CATEGORIA_LACTEOS = "Lacteos";

    public static final int TIPO_NOMBRE_PRODUCTO = 2;

    public static final int TIPO_FILTROS = 3;

    private Button buttonFiltrar;
    private ListView listViewBuscar;

    private Usuario usuario = new Usuario();

    private int busqueda = -1;
    private String categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        System.out.println("Just entered BuscarActivity");
        Toast.makeText(this, "Just entered BuscarActivity", Toast.LENGTH_LONG).show();

        recieveBundles(this);

        buttonFiltrar = findViewById(R.id.buttonFiltrar);
        buttonFiltrar.setOnClickListener(buttonFiltrarListener);

        //Object[] items = new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Object[] items = new Object[] {};
        BusquedaAdapter adaptador = new BusquedaAdapter(this, R.layout.list_item_buscar, items);
        listViewBuscar = findViewById(R.id.listViewBuscar);
        listViewBuscar.setAdapter(adaptador);

        listViewBuscar.setOnItemClickListener(listViewBuscarListener);

        buscar();
    }

    private void buscar() {
        switch (busqueda) {
            case -1: {
                Toast.makeText(this, "Ningun tipo de busqueda detectado (-1)", Toast.LENGTH_LONG).show();
                break;
            }

            case TIPO_CATEGORIA: {
                Toast.makeText(this, "Tipo de busqueda 'CATEGORIA'", Toast.LENGTH_LONG).show();

                /*LectorProducto lectorProducto = new LectorProducto();
                List<Integer> idProductos = lectorProducto.getIdProductosConCategoria(categoria);

                System.out.println("Se obtuvieron los siguientes productos con la categoria '" + categoria + "'");
                System.out.println(idProductos);*/

                break;
            }

            case TIPO_NOMBRE_PRODUCTO: {
                Toast.makeText(this, "Tipo de busqueda 'NOMBRE PRODUCTO'", Toast.LENGTH_LONG).show();
                break;
            }

            case TIPO_FILTROS: {
                Toast.makeText(this, "Tipo de busqueda 'FILTROS'", Toast.LENGTH_LONG).show();
                break;
            }

            default: {
                Toast.makeText(this, "Ningun tipo de busqueda detectado (d)", Toast.LENGTH_LONG).show();
            }
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

        if (intent.hasExtra(TIPO_BUSQUEDA)) {
            busqueda = intent.getIntExtra(TIPO_BUSQUEDA, -1);
            categoria = intent.getStringExtra(BUSQUEDA_CATEGORIA);
        } else
            busqueda = -1;

        Toast.makeText(this, "Just recieved extras", Toast.LENGTH_LONG).show();
    }
}
