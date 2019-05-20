package com.example.agrostore01.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.agrostore01.R;

import java.util.ArrayList;

public class BusquedaAdapter extends ArrayAdapter {

    static class Datos {
        public ImageView imageViewItemBuscar;
        public TextView textViewItemBuscarTitulo;
        public TextView textViewItemBuscarPrecio;
        public LinearLayout linearLayoutItemBuscar;
        public TextView textViewItemBuscarVentas;
    }

    private  Context context;
    private int layoutResourceId;
    private ArrayList lista;

    public BusquedaAdapter(Context context, int resource, Object[] objects) {
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

            data.imageViewItemBuscar = convertView.findViewById(R.id.imageViewItemBuscar);
            data.textViewItemBuscarTitulo = convertView.findViewById(R.id.textViewItemBuscarTitulo);
            data.textViewItemBuscarPrecio = convertView.findViewById(R.id.textViewItemBuscarPrecio);
            data.linearLayoutItemBuscar = convertView.findViewById(R.id.linearLayoutItemBuscar);
            data.textViewItemBuscarVentas = convertView.findViewById(R.id.textViewItemBuscarVentas);

            convertView.setTag(data);

        } else {
            data = (Datos) convertView.getTag();
        }

        return convertView;
    }
}
