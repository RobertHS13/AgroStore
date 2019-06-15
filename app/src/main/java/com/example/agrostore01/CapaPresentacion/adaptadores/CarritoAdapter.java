package com.example.agrostore01.CapaPresentacion.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.example.agrostore01.R;

import java.util.List;

public class CarritoAdapter extends ArrayAdapter<String> {

    static class Datos {
        ImageView ivCarrito;
        TextView tvProducto;
        TextView tvUnidades;
        TextView tvPrecio;
        EditText etCantidad;
    }

    private Context context;
    private int layoutResourceId;
    private List<String> items;

    public CarritoAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);

        this.context = context;
        this.layoutResourceId = resource;
        this.items = items;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Datos data;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutResourceId, parent, false);
            data = new Datos();

            data.ivCarrito = convertView.findViewById(R.id.ivItemCarrito);
            data.tvProducto = convertView.findViewById(R.id.tvItemCarritoProducto);
            data.tvUnidades = convertView.findViewById(R.id.tvItemCarritoUnidades);
            data.tvPrecio = convertView.findViewById(R.id.tvItemCarritoPrecio);
            data.etCantidad = convertView.findViewById(R.id.etItemCarritoCantidad);

            convertView.setTag(data);

        } else {
            data = (Datos) convertView.getTag();
        }

        String item = items.get(position);

        data.tvProducto.setText(item);

        return convertView;
    }

}
