package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.CapaEntidades.vistas.VistaBusquedaProducto;
import com.example.agrostore01.CapaNegocios.lectores.vistas.LectorVistaBusquedaProducto;
import com.example.agrostore01.R;

import java.math.BigDecimal;

public class DetallesProductoActivity extends RecieveBundlesActivity {

    private ImageView ivImagenProducto;
    private TextView tvTitulo, tvPrecio, tvLocalidad;
    private RatingBar rbEstrellas;
    private TextView tvVendedor, tvProducto, tvDescripcion;

    private Usuario usuario = new Usuario();
    private int idProducto;
    private VistaBusquedaProducto vistaProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_producto);

        recieveBundles(this);

        ivImagenProducto = findViewById(R.id.imageViewItemDetallesProducto);
        tvTitulo = findViewById(R.id.textViewItemDetallesTitulo);
        tvPrecio = findViewById(R.id.textViewItemDetallesPrecio);
        tvLocalidad = findViewById(R.id.textViewItemDetallesLocalidad);
        rbEstrellas = findViewById(R.id.rbItemDetallesEstrellas);
        tvVendedor = findViewById(R.id.tvDetallesProductoVendedor);
        tvProducto = findViewById(R.id.tvDetallesProductoNombreProducto);
        tvDescripcion = findViewById(R.id.tvDetallesProductoDescripcion);

        new LlenarCampos().execute();
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
        idProducto = getIntent().getIntExtra("idProducto", -1);
    }

    private class LlenarCampos extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            System.out.println("Just started thread");
        }

        @Override
        protected Void doInBackground(Void... voids) {

            System.out.println("Executing thread");

            LectorVistaBusquedaProducto lectorVistaBusquedaProducto = new LectorVistaBusquedaProducto();
            vistaProducto = lectorVistaBusquedaProducto.getEntidadId(idProducto);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            String titulo = vistaProducto.getProducto();
            String precio = "$" + vistaProducto.getPrecio().setScale(2, BigDecimal.ROUND_HALF_UP) + ", " + vistaProducto.getHectareas() + " hectareas";
            String localidad = vistaProducto.getCiudad() + ", " + vistaProducto.getEstado();

            tvTitulo.setText(titulo);
            tvPrecio.setText(precio);
            tvLocalidad.setText(localidad);

            System.out.println("Just finished thread");
        }
    }

}
