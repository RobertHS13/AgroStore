package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.agrostore01.CapaDatos.conexiones.BaseDeDatos;
import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;

public class LoginActivity extends AppCompatActivity {

    private ImageButton ibInicioSesion, ibIniciar, ibRecuperarCuenta;
    private EditText etCorreoElectronico, etContrasena;

    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ibInicioSesion = findViewById(R.id.imageButton2);
        ibIniciar = findViewById(R.id.imageButton);
        ibRecuperarCuenta = findViewById(R.id.ibRecuperarCuenta);
        etCorreoElectronico = findViewById(R.id.etCorreoElec);
        etContrasena = findViewById(R.id.etContra);

        ibInicioSesion.setOnClickListener(ibInicioSesionListener);
        ibIniciar.setOnClickListener(ibIniciarListener);
        ibRecuperarCuenta.setOnClickListener(ibRecuperarCuentaListener);
    }

    private final View.OnClickListener ibInicioSesionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
            startActivity(intent);
        }
    };

    private final View.OnClickListener ibIniciarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            /*
             * private String idUsuario;
             * private String contraseñaUsuario;
             * private int idTipo;
             * private long idDetalles;
             * private byte[] foto;
             * private String correo;
             */
            usuario = new Usuario("AlexCR97", "12345", 1, 1, null, "ale@live.com");

            Intent intent = new Intent(LoginActivity.this, BarraActivity.class);

            intent.putExtra(usuario.getClassName(), usuario);

            startActivity(intent);
        }
    };

    private final View.OnClickListener ibRecuperarCuentaListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            BaseDeDatos bd = new BaseDeDatos();
            boolean success = bd.getConexion() != null;
            if (!success)
                Toast.makeText(v.getContext(), "Connection failed :(", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(v.getContext(), "Connection successful! :D", Toast.LENGTH_SHORT).show();
        }
    };

    public ImageButton getIbInicioSesion() { return ibInicioSesion; }
    public ImageButton getIbIniciar() { return ibIniciar; }
    public EditText getEtCorreoElectronico() { return etCorreoElectronico; }
    public EditText getEtContrasema() { return etContrasena; }
}
