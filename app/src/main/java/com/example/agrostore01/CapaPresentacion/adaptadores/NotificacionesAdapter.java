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

import java.util.List;

public class NotificacionesAdapter extends ArrayAdapter<String> {

    static class Datos {
        public ImageView ivNotificacion;
        public TextView tvNotificacion;
    }

    private  Context context;
    private int layoutResourceId;
    private List<String> items;

    public NotificacionesAdapter(Context context, int resource, List<String> items) {
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

            data.ivNotificacion = convertView.findViewById(R.id.ivNotificacion);
            data.tvNotificacion = convertView.findViewById(R.id.tvNotificacion);

            convertView.setTag(data);

        } else {
            data = (Datos) convertView.getTag();
        }

        String notificacion = items.get(position);

        data.tvNotificacion.setText(notificacion);

        return convertView;
    }
}
