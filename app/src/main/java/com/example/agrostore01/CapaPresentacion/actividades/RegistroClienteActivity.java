package com.example.agrostore01.CapaPresentacion.actividades;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


import com.example.agrostore01.CapaEntidades.DetallesUsuario;
import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.CapaNegocios.validaciones.ValidacionDetalles;
import com.example.agrostore01.CapaNegocios.validaciones.ValidacionUsuario;
import com.example.agrostore01.R;

import java.util.Calendar;

public class RegistroClienteActivity extends AppCompatActivity {

    private EditText etUsuario, etNombres, etContrasena, etConfirmarContrasena, etCorreoElectronico, etCorreoRespaldo;
    private EditText etCalle, etColonia, etCiudad, etCodigoPostal;
    private ImageButton ibFecha, ibRegistrar;
    private CheckBox cbTerminos;
    private String sFecha;
    private TextView tvFecha;
    private int dia, mes, anno;
    private Spinner sEstado, sPais;

    private Usuario usuario = new Usuario();
    private DetallesUsuario detallesUsuario = new DetallesUsuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cliente);

        etUsuario = findViewById(R.id.etRegistroClienteUsuario);
        etNombres = findViewById(R.id.etRegistroClienteNombres);
        etContrasena = findViewById(R.id.etRegistroClienteContrasena);
        etConfirmarContrasena = findViewById(R.id.etRegistroClienteConfirmarContrasena);
        etCorreoElectronico = findViewById(R.id.etRegistroClienteCorreoElectronico);
        etCorreoRespaldo = findViewById(R.id.etRegistroClienteCorreoRespaldo);
        sEstado = findViewById(R.id.sEstado);
        sPais = findViewById(R.id.sPais);

        etCalle = findViewById(R.id.etRegistroClienteCalle);
        etColonia = findViewById(R.id.etRegistroClienteColonia);
        etCiudad = findViewById(R.id.etRegistroClienteCiudad);
        etCodigoPostal = findViewById(R.id.etRegistroClienteCodigoPostal);


        ibFecha = findViewById(R.id.ibRegistroClienteFechaNac);
        ibRegistrar = findViewById(R.id.ibRegistroClienteRegistrar);
        tvFecha = findViewById(R.id.tvFecha);
        cbTerminos = findViewById(R.id.cbRegistroClienteTerminos);

        ibFecha.setOnClickListener(ibFechaListener);
        ibRegistrar.setOnClickListener(ibRegistrarListener);

        String[] paises = new String[] {"México"};
        ArrayAdapter<String> adapterPais = new ArrayAdapter<String>(this, R.layout.list_item_spinner, paises);
        sPais.setAdapter(adapterPais);

        String[] estados = new String[] {"Aguascalientes","Baja California","Baja California Sur","Campeche","Coahuila de Zaragoza","Colima"
                ,"Chiapas","Chihuahua","Distrito Federal","Durango","Guanajuato","Guerrero","Hidalgo","Jalisco","México","Michoacán de Ocampo"
                ,"Morelos","Nayarit","Nuevo León","Oaxaca","Puebla","Querétaro","Quintana Roo","San Luis Potosí","Sinaloa","Sonora","Tabasco"
                ,"Tamaulipas","Tlaxcala","Veracruz de Ignacio de la Llave","Yucatán","Zacatecas"};
        ArrayAdapter<String> adapterEstado = new ArrayAdapter<String>(this, R.layout.list_item_spinner, estados);
        sEstado.setAdapter(adapterEstado);

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
            , anno, mes, dia);
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

            // Datos del usuario
            String idUsuario = "User" + etUsuario.getText().toString();
            byte[] foto = null;
            int idTipo = 0;
            long idDetalles = 0;
            String nombreUsuario = etUsuario.getText().toString();
            String contrasena = etContrasena.getText().toString();
            String confirmarContrasena = etConfirmarContrasena.getText().toString();
            String correoElectronico = etCorreoElectronico.getText().toString();

            // Detalles del usuario
            String calle = etCalle.getText().toString();
            String colonia = etColonia.getText().toString();
            String ciudad = etCiudad.getText().toString();
            String estado = sEstado.getSelectedItem().toString();
            String pais = sPais.getSelectedItem().toString();
            String codigoPostal = etCodigoPostal.getText().toString();
            int cp = codigoPostal.isEmpty()? 0 : Integer.parseInt(codigoPostal);
            String escrituraOPermiso = "";
            double estrellas = 0;
            String rfc = "";
            String firmaElectronica = "";
            String nombres = etNombres.getText().toString();
            String apellidos = etNombres.getText().toString();

            if (!cbTerminos.isChecked()) {
                Toast.makeText(RegistroClienteActivity.this, "Debes aceptar los terminos y condiciones", Toast.LENGTH_SHORT).show();
                exito = false;
                return;
            }

            if (!contrasena.equals(confirmarContrasena)) {
                Toast.makeText(RegistroClienteActivity.this, "Verifica las contraseñas", Toast.LENGTH_SHORT).show();
                exito = false;
                return;
            }

            usuario = new Usuario(idUsuario, foto, idTipo, idDetalles, nombreUsuario, contrasena, correoElectronico);
            detallesUsuario = new DetallesUsuario(calle, colonia, ciudad, estado, pais, cp, escrituraOPermiso, estrellas, rfc, firmaElectronica, nombres, apellidos);

            ValidacionUsuario validacionUsuario = new ValidacionUsuario(usuario);
            boolean validarUsuario = validacionUsuario.validar();

            ValidacionDetalles validacionDetalles = new ValidacionDetalles(detallesUsuario);
            boolean validarDetalles = validacionDetalles.validar();

            if (!validarUsuario) {
                Toast.makeText(RegistroClienteActivity.this, "Verifica que hayas ingresado correctamente tus datos de usuario", Toast.LENGTH_SHORT).show();
                exito = false;
                return;
            }

            if (!validarDetalles) {
                Toast.makeText(RegistroClienteActivity.this, "Verifica que hayas ingresado correctamente tu domicilio", Toast.LENGTH_SHORT).show();
                exito = false;
                return;
            }

            exito = true;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (!exito)
                return;

            Intent intent = new Intent(RegistroClienteActivity.this, BarraActivity.class);
            intent.putExtra(usuario.getClassName(), usuario);
            intent.putExtra(detallesUsuario.getClassName(), detallesUsuario);
            startActivity(intent);
            finish();
        }
    }

    public ImageButton getIbRegistrar() { return ibRegistrar; }
    public ImageButton getIbFecha() { return ibFecha; }
    public String getFecha() { return sFecha; }
    public TextView getTvFecha() { return tvFecha; }
    public EditText getEtNombres() { return etNombres; }
    public EditText getEtContrasena() { return etContrasena; }
    public EditText getEtConfirmarContrasena() { return etConfirmarContrasena; }
    public EditText getEtCorreoElectronico() { return etCorreoElectronico; }
    public EditText getEtCorreoRespaldo() { return etCorreoRespaldo; }


}


