package com.example.agrostore01.CapaPresentacion.actividades;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;

public class EstadoVentaActivity extends RecieveBundlesActivity {

    private Button buttonEstadoVenta;

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_venta);
        recieveBundles(this);
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }

}
