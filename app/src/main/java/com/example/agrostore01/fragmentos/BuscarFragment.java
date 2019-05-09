package com.example.agrostore01.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.agrostore01.R;
import com.example.agrostore01.actividades.BuscarActivity;

public class BuscarFragment extends Fragment {

    private SearchView buscador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_buscar, container, false);

        buscador = vista.findViewById(R.id.searchViewBuscadorFragmento);

        buscador.setOnQueryTextListener(buscadorListener);
        return vista;
    }

    private final SearchView.OnQueryTextListener buscadorListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {

            Intent intent = new Intent(getActivity(), BuscarActivity.class);
            startActivity(intent);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };
}
