package com.example.agrostore01.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.agrostore01.R;

public class MisVentasAdapter extends ArrayAdapter {

    static class Datos {
        public ImageView imageViewItemMisVentas;
        public TextView textViewItemMisVentasCliente;
        public TextView textViewItemMisVentasPedido;
        public LinearLayout linearLayoutItemMisVentas;
    }

    private  Context context;
    private int layoutResourceId;
    private Object[] items;

    public MisVentasAdapter(Context context, int resource, Object[] items) {
        super(context, resource, items);

        this.context = context;
        this.layoutResourceId = resource;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Datos data = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutResourceId, parent, false);
            data = new Datos();

            data.imageViewItemMisVentas = convertView.findViewById(R.id.imageViewItemMisVentas);
            data.textViewItemMisVentasCliente = convertView.findViewById(R.id.textViewItemMisVentasCliente);
            data.textViewItemMisVentasPedido = convertView.findViewById(R.id.textViewItemMisVentasPedido);
            data.linearLayoutItemMisVentas = convertView.findViewById(R.id.linearLayoutItemMisVentas);

            convertView.setTag(data);

        } else {
            data = (Datos) convertView.getTag();
        }

        return convertView;
    }
}
