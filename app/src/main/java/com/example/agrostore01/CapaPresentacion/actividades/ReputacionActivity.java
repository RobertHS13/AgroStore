package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;
import android.widget.TextView;
import android.widget.ProgressBar;


public class ReputacionActivity extends RecieveBundlesActivity {

    private TextView tvTotalOpe, tvConcretadas, tvCanceladas, tvPositivas, tvNeutrales, tvNegativas;
    private ProgressBar pbReputacion;

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reputacion);

        tvTotalOpe = findViewById(R.id.tvTotalOperaciones);
        tvConcretadas = findViewById(R.id.tvConcretadas);
        tvCanceladas = findViewById(R.id.tvCanceladas);
        tvPositivas = findViewById(R.id.tvPositivas);
        tvNeutrales = findViewById(R.id.tvNeutrales);
        tvNegativas = findViewById(R.id.tvNegativas);
        pbReputacion = findViewById(R.id.pbReputacion);

        recieveBundles(this);
    }

    public TextView getTvTotalOpe() {
        return tvTotalOpe;
    }
    public TextView getTvConcretadas() {
        return tvConcretadas;
    }
    public TextView getTvCanceladas() {
        return tvCanceladas;
    }
    public TextView getTvPositivas() {
        return tvPositivas;
    }
    public TextView getTvNeutrales() {
        return tvNeutrales;
    }
    public TextView getTvNegativas() {
        return tvNegativas;
    }
    public ProgressBar getPbReputacion() {
        return pbReputacion;
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
    }
}
