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
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.CapaPresentacion.actividades.RecieveBundlesFragment;
import com.example.agrostore01.R;
import com.example.agrostore01.CapaPresentacion.actividades.BuscarActivity;

public class BuscarFragment extends RecieveBundlesFragment {

    private SearchView buscador;
    private ImageView imageViewHortalizas;
    private ImageView imageViewSemillas;
    private ImageView imageViewCarnes;
    private ImageView imageViewLacteos;

    private Usuario usuario = new Usuario();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_buscar, container, false);

        buscador = vista.findViewById(R.id.searchViewBuscadorFragmento);
        buscador.setOnQueryTextListener(buscadorListener);

        imageViewHortalizas = vista.findViewById(R.id.imageViewBuscarHortalizas);
        imageViewSemillas = vista.findViewById(R.id.imageViewBuscarSemillas);
        imageViewCarnes = vista.findViewById(R.id.imageViewBuscarCarnes);
        imageViewLacteos = vista.findViewById(R.id.imageViewBuscarLacteos);

        imageViewHortalizas.setOnClickListener(imageViewHortalizasOnClickListener);
        imageViewSemillas.setOnClickListener(imageViewSemillasOnClickListener);
        imageViewCarnes.setOnClickListener(imageViewCarnesOnClickListener);
        imageViewLacteos.setOnClickListener(imageViewLacteosOnClickListener);

        recieveBundles(vista.getContext());

        return vista;
    }

    private final SearchView.OnQueryTextListener buscadorListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            Intent intent = new Intent(getActivity(), BuscarActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    private final View.OnClickListener imageViewHortalizasOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), BuscarActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
        }
    };

    private final View.OnClickListener imageViewSemillasOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), BuscarActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
        }
    };

    private final View.OnClickListener imageViewCarnesOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), BuscarActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
        }
    };

    private final View.OnClickListener imageViewLacteosOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), BuscarActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
        }
    };

    @Override
    public void recieveBundles(Context context) {
        usuario = getArguments().getParcelable(usuario.getClassName());
        Toast.makeText(context, usuario.toString(), Toast.LENGTH_LONG).show();
    }
}
