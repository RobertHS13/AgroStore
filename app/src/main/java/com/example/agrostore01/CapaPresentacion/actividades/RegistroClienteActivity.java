package com.example.agrostore01.CapaPresentacion.actividades;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


import com.example.agrostore01.CapaEntidades.DetallesUsuario;
import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;

import java.util.Calendar;

public class RegistroClienteActivity extends AppCompatActivity {

    private ImageButton ibRegistrar,ibFecha;
    private String sFecha;
    private TextView tvFecha;
    private EditText etNombre, etContrasena, etConfirmarContrasena, etCorreoElectronico, etCorreoRespaldo, etDireccion;
    private int dia, mes, anno;

    private Usuario usuario;
    private DetallesUsuario detallesUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cliente);

        ibRegistrar = findViewById(R.id.ibRegistrar);
        ibFecha = findViewById(R.id.ibFecha);

        tvFecha = findViewById(R.id.tvFecha);

        ibFecha.setOnClickListener(ibFechaListener);
        ibRegistrar.setOnClickListener(ibRegistrarListener);

        etNombre = findViewById(R.id.etNombre);
        etContrasena = findViewById(R.id.etContra);
        etConfirmarContrasena = findViewById(R.id.etConfirmarContra);
        etCorreoElectronico = findViewById(R.id.etCorreoElec);
        etCorreoRespaldo = findViewById(R.id.etCorreoRespaldo);
    }

    private final View.OnClickListener ibFechaListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anno = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    sFecha = (dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    tvFecha.setText(sFecha);
                    tvFecha.setVisibility(View.VISIBLE);
                }
            }
            , dia, mes, anno);
            datePickerDialog.show();
        }
    };

    private final View.OnClickListener ibRegistrarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new VerificarRegistro().execute();
        }
    };

    private class VerificarRegistro extends AsyncTask<Void, Void, Void> {

        private boolean exito;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            String nombre = etNombre.getText().toString();
            String contrasena = etContrasena.getText().toString();
            String confirmarContrasena = etConfirmarContrasena.getText().toString();
            String correoElectronico = etCorreoElectronico.getText().toString();
            String correoRespaldo = etCorreoRespaldo.getText().toString();

            if (!contrasena.equals(confirmarContrasena)) {
                Toast.makeText(RegistroClienteActivity.this, "Verifica las contraseñas", Toast.LENGTH_SHORT).show();
                return;
            }

            // Usuario
            String idUsuario = "";
            byte[] foto = null;
            int idTipo = 0;
            long idDetalles = 0;
            String usuario = "";
            String contrasenaUsuario = "";
            String correo = "";

            RegistroClienteActivity.this.usuario = new Usuario(idUsuario, foto, idTipo, idDetalles, usuario, contrasenaUsuario, correo);

            // Detalles Usuario

            String calle = "";
            String colonia = "";
            String ciudad = "";
            String estado = "";
            String pais = "";
            int cp = 0;
            String escrituraOPermiso = "";
            double estrellas = 0;
            String rfc = "";
            String firmaElectronica = "";
            String nombres = "";
            String apellidos = "";

            detallesUsuario = new DetallesUsuario(calle, colonia, ciudad, estado, pais, cp, escrituraOPermiso, estrellas, rfc, firmaElectronica, nombres, apellidos);

            exito = true;
        }

        @Override
        protected Void doInBackground(Void... voids) {


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (!exito) {
                Toast.makeText(
                        RegistroClienteActivity.this,
                        "Hubo un error en el registro. Verifica todos tus datos e intenta de nuevo",
                        Toast.LENGTH_LONG
                ).show();
                return;
            }

            Intent intent = new Intent(RegistroClienteActivity.this, BarraActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);
            intent.putExtra(detallesUsuario.getClassName(), detallesUsuario);
            startActivity(intent);
            finish();
        }
    }

    public ImageButton getIbRegistrar() {
        return ibRegistrar;
    }

    public ImageButton getIbFecha() {
        return ibFecha;
    }

    public String getsFecha() {
        return sFecha;
    }

    public TextView getTvFecha() {
        return tvFecha;
    }

    public EditText getEtNombre() {
        return etNombre;
    }

    public EditText getEtContrasena() {
        return etContrasena;
    }

    public EditText getEtConfirmarContrasena() {
        return etConfirmarContrasena;
    }

    public EditText getEtCorreoElectronico() {
        return etCorreoElectronico;
    }

    public EditText getEtCorreoRespaldo() {
        return etCorreoRespaldo;
    }

    public EditText getEtDireccion() {
        return etDireccion;
    }
}
