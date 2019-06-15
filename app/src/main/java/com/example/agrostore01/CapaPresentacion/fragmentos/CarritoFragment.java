package com.example.agrostore01.CapaPresentacion.fragmentos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.CapaPresentacion.actividades.RecieveBundlesFragment;
import com.example.agrostore01.R;
import com.example.agrostore01.CapaPresentacion.actividades.CompraActivity;
import com.example.agrostore01.CapaPresentacion.adaptadores.CarritoAdapter;

import java.util.Arrays;
import java.util.List;

public class CarritoFragment extends RecieveBundlesFragment {

    private ListView listViewCarrito;
    private Button buttonComprarCarrito;

    private Usuario usuario = new Usuario();

    private CarritoAdapter adapter;
    private List<String> carrito = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_carrito, container, false);

        recieveBundles(vista.getContext());

        listViewCarrito = vista.findViewById(R.id.listViewCarrito);
        buttonComprarCarrito = vista.findViewById(R.id.buttonCarritoComprar);

        adapter = new CarritoAdapter(vista.getContext(), R.layout.list_item_carrito, carrito);
        listViewCarrito.setAdapter(adapter);

        listViewCarrito.setOnItemLongClickListener(listViewCarritoListener);
        buttonComprarCarrito.setOnClickListener(buttonComprarCarritoListener);

        return vista;
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getArguments().getParcelable(usuario.getClassName());
        Toast.makeText(context, usuario.toString(), Toast.LENGTH_LONG).show();
    }

    private void addTitleRow(Context context, TableLayout table, String title) {

    }

    private void addSeparatorRow(Context context, TableLayout table) {

    }

    private void addPriceRow(Context context, TableLayout table, String title, String price) {
        System.out.println("Total childs of table before add is " + table.getChildCount());
        table.removeAllViews();

        TableRow row = new TableRow(context);
        row.setLayoutParams(new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));

        TextView tvTitle = new TextView(context);
        tvTitle.setLayoutParams(new TableLayout.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));
        tvTitle.setText(title);

        Space space = new Space(context);

        TextView tvPrice = new TextView(context);
        tvPrice.setLayoutParams(new TableLayout.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));
        tvPrice.setText(price);

        row.addView(tvTitle, 0);
        row.addView(space, 1);
        row.addView(tvPrice, 2);
        table.addView(row);

        System.out.println("Total childs of table before add is " + table.getChildCount());
    }

    private final AdapterView.OnItemLongClickListener listViewCarritoListener = new AdapterView.OnItemLongClickListener() {

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

            Toast.makeText(view.getContext(), "Clicked item " + carrito.get(position), Toast.LENGTH_SHORT).show();

            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE: {
                            carrito.remove(position);
                            adapter.notifyDataSetChanged();
                            break;
                        }

                        case DialogInterface.BUTTON_NEGATIVE:
                            dialog.cancel();
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setMessage("Estas seguro de que quieres quitar este producto de tu carrito?")
                    .setPositiveButton("Si", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener)
                    .show();

            return false;
        }
    };

    private final View.OnClickListener buttonComprarCarritoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), CompraActivity.class);
            startActivity(intent);
        }
    };

}
