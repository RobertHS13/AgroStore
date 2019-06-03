package com.example.agrostore01.CapaPresentacion.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.agrostore01.R;

import java.util.ArrayList;

public class CarritoAdapter extends ArrayAdapter {

    static class Datos {
        public ImageView imageViewItemCarrito;
        public TextView textViewItemCarritoTitulo;
        public TextView textViewItemCarritoCantidad;
        public LinearLayout linearLayoutItemCarrito;
        public TextView textViewItemCarritoPrecio;
    }

    private  Context context;
    private int layoutResourceId;
    private ArrayList lista;

    public CarritoAdapter(Context context, int resource, Object[] objects) {
        super(context, resource, objects);

        this.context = context;
        this.layoutResourceId = resource;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Datos data = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutResourceId, parent, false);
            data = new Datos();

            data.imageViewItemCarrito = convertView.findViewById(R.id.imageViewItemCarrito);
            data.textViewItemCarritoTitulo = convertView.findViewById(R.id.textViewItemCarritoTitulo);
            data.textViewItemCarritoCantidad = convertView.findViewById(R.id.textViewItemCarritoCantidad);
            data.linearLayoutItemCarrito = convertView.findViewById(R.id.linearLayoutItemCarrito);
            data.textViewItemCarritoPrecio = convertView.findViewById(R.id.textViewItemCarritoPrecio);

            convertView.setTag(data);

        } else {
            data = (Datos) convertView.getTag();
        }

        return convertView;
    }
}
