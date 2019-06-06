package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class ConfigurarCuentaActivity extends RecieveBundlesActivity {

    private EditText etVerificacionEji, etCuentaBan, etCodigoSat, etDireccionFis, etRFC;
    private ImageButton ibRecuperarCuenta, ibDarAlta;

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        ibRecuperarCuenta = findViewById(R.id.ibRecuperarCuenta);
        ibDarAlta = findViewById(R.id.ibDarAlta);

        etVerificacionEji = findViewById(R.id.etVerificarEji);
        etCuentaBan = findViewById(R.id.etCuentaBan);
        etCodigoSat = findViewById(R.id.etSAT);
        etDireccionFis = findViewById(R.id.etDireccionFis);
        etRFC = findViewById(R.id.etRFC);

        ibRecuperarCuenta.setOnClickListener(ibRecuperarCuentaListener);
        ibDarAlta.setOnClickListener(ibDarAltaListener);

        recieveBundles(this);
    }

    private final View.OnClickListener ibRecuperarCuentaListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private final View.OnClickListener ibDarAltaListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public EditText getEtVerificacionEji() {
        return etVerificacionEji;
    }
    public EditText getEtCuentaBan() {
        return etCuentaBan;
    }
    public EditText getEtCodigoSat() {
        return etCodigoSat;
    }
    public EditText getEtDireccionFis() {
        return etDireccionFis;
    }
    public EditText getEtRFC() {
        return etRFC;
    }
    public ImageButton getIbRecuperarCuenta() {
        return ibRecuperarCuenta;
    }
    public ImageButton getIbDarAlta() {
        return ibDarAlta;
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }
}
