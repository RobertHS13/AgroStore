package com.example.agrostore01.CapaPresentacion.fragmentos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.CapaPresentacion.actividades.RecieveBundlesFragment;
import com.example.agrostore01.R;
import com.example.agrostore01.CapaPresentacion.actividades.CompraActivity;
import com.example.agrostore01.CapaPresentacion.adaptadores.CarritoAdapter;

public class CarritoFragment extends RecieveBundlesFragment {

    private Button buttonComprarCarrito;
    private ListView listViewCarrito;

    private Usuario usuario = new Usuario();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_carrito, container, false);

        buttonComprarCarrito = vista.findViewById(R.id.buttonCarritoComprar);
        buttonComprarCarrito.setOnClickListener(buttonComprarCarritoListener);

        Object[] items = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        CarritoAdapter adapter = new CarritoAdapter(vista.getContext(), R.layout.list_item_carrito, items);
        listViewCarrito = vista.findViewById(R.id.listViewCarrito);
        listViewCarrito.setAdapter(adapter);

        recieveBundles(vista.getContext());

        return vista;
    }

    private final View.OnClickListener buttonComprarCarritoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), CompraActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public void recieveBundles(Context context) {
        usuario = getArguments().getParcelable(usuario.getClassName());
        Toast.makeText(context, usuario.toString(), Toast.LENGTH_LONG).show();
    }

}
