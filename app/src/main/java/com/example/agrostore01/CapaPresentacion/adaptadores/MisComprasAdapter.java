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

public class MisComprasAdapter extends ArrayAdapter {

    static class Datos {
        public ImageView imageViewItemMisCompras;
        public TextView textViewItemMisComprasPedido;
        public TextView textViewItemMisComprasVendedor;
        public LinearLayout linearLayoutItemMisCompras;
    }

    private  Context context;
    private int layoutResourceId;
    private Object[] items;

    public MisComprasAdapter(Context context, int resource, Object[] items) {
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

            data.imageViewItemMisCompras = convertView.findViewById(R.id.imageViewItemMisCompras);
            data.textViewItemMisComprasPedido = convertView.findViewById(R.id.textViewItemMisComprasPedido);
            data.textViewItemMisComprasVendedor = convertView.findViewById(R.id.textViewItemMisComprasVendedor);
            data.linearLayoutItemMisCompras = convertView.findViewById(R.id.linearLayoutItemMisCompras);

            convertView.setTag(data);

        } else {
            data = (Datos) convertView.getTag();
        }

        return convertView;
    }
}
