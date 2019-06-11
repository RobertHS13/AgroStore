package com.example.agrostore01.CapaPresentacion.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.agrostore01.CapaEntidades.vistas.VistaMisVentas;
import com.example.agrostore01.R;

import java.util.List;

public class MisVentasAdapter extends ArrayAdapter<VistaMisVentas> {

    static class Datos {
        ImageView imageViewItemMisVentas;
        TextView tvNumeroVenta;
        TextView tvPrecio;
        TextView tvProducto;
        TextView tvFecha;
    }

    private  Context context;
    private int layoutResourceId;
    private List<VistaMisVentas> items;

    public MisVentasAdapter(Context context, int resource, List<VistaMisVentas> items) {
        super(context, resource, items);

        this.context = context;
        this.layoutResourceId = resource;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Datos data;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutResourceId, parent, false);
            data = new Datos();

            data.imageViewItemMisVentas = convertView.findViewById(R.id.ivMisVentas);
            data.tvNumeroVenta = convertView.findViewById(R.id.tvMisVentasNumeroVenta);
            data.tvPrecio = convertView.findViewById(R.id.tvMisVentasPrecio);
            data.tvProducto = convertView.findViewById(R.id.tvMisVentasProducto);
            data.tvFecha = convertView.findViewById(R.id.tvMisVentasFecha);

            convertView.setTag(data);

        } else {
            data = (Datos) convertView.getTag();
        }

        /**
         *     private int numeroDeVenta;
         *     private BigDecimal precio;
         *     private String producto;
         *     private String fecha;
         */

        VistaMisVentas miVenta = items.get(position);

        String numeroVenta = "#" + miVenta.getNumeroDeVenta();
        String precio = "$" + miVenta.getPrecio().toString();
        String producto = miVenta.getProducto();
        String fecha = miVenta.getFecha();

        data.tvNumeroVenta.setText(numeroVenta);
        data.tvPrecio.setText(precio);
        data.tvProducto.setText(producto);
        data.tvFecha.setText(fecha);

        return convertView;
    }
}
