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

public class NotificacionesAdapter extends ArrayAdapter {

    static class Datos {
        public ImageView imageViewItemNotifyCliente;
        public TextView textViewNotifyUser;
        public TextView textViewItemNotifyReaction;
        public LinearLayout linearLayoutItemNotifyCliente;
    }

    private  Context context;
    private int layoutResourceId;
    private Object[] items;

    public NotificacionesAdapter(Context context, int resource, Object[] items) {
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

            data.imageViewItemNotifyCliente = convertView.findViewById(R.id.imageViewItemNotifyCliente);
            data.textViewNotifyUser = convertView.findViewById(R.id.textViewNotifyUser);
            data.textViewItemNotifyReaction = convertView.findViewById(R.id.textViewItemNotifyReaction);
            data.linearLayoutItemNotifyCliente = convertView.findViewById(R.id.linearLayoutItemNotifyCliente);

            convertView.setTag(data);

        } else {
            data = (Datos) convertView.getTag();
        }

        return convertView;
    }
}
