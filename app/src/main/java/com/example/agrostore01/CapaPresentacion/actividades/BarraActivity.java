package com.example.agrostore01.CapaPresentacion.actividades;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.agrostore01.CapaEntidades.Usuario;
import com.example.agrostore01.R;
import com.example.agrostore01.CapaPresentacion.fragmentos.BuscarFragment;
import com.example.agrostore01.CapaPresentacion.fragmentos.CarritoFragment;
import com.example.agrostore01.CapaPresentacion.fragmentos.DashboardFragment;
import com.example.agrostore01.CapaPresentacion.fragmentos.NotificacionesFragment;

public class BarraActivity extends RecieveBundlesActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navegador;

    private DashboardFragment dashboardFragment = new DashboardFragment();
    private BuscarFragment buscarFragment = new BuscarFragment();
    private CarritoFragment carritoFragment = new CarritoFragment();
    private NotificacionesFragment notificacionesFragment = new NotificacionesFragment();

    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barra);

        // DRAWER //////////////////////////////////////////////////////////////////////////////////
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // NAVIGATION //////////////////////////////////////////////////////////////////////////////
        //ViewPager viewPager = findViewById(R.id.ViewPagerOfertas);
        //ImagenAdapter adapter = new ImagenAdapter(this);
        //viewPager.setAdapter(adapter);

        recieveBundles(this);
        String idUsuario = usuario.getIdUsuario();

        navegador = findViewById(R.id.navigation);
        navegador.setOnNavigationItemSelectedListener(navegadorListener);

        // fragmento for defecto
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, dashboardFragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navegadorListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragmento = null;

            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    fragmento = dashboardFragment;
                    break;
                case R.id.navigation_buscar:
                    fragmento = buscarFragment;
                    break;
                case R.id.navigation_carrito:
                    fragmento = carritoFragment;
                    break;
                case R.id.navigation_notificaciones:
                    fragmento = notificacionesFragment;
                    break;
            }

            if (fragmento == null)
                return false;

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragmento).commit();

            return true;
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.barra, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.perfil) {
            Intent intent= new Intent(BarraActivity.this,PerfilUsuarioActivity.class);
            startActivity(intent);
        }

        else if (id == R.id.miterreno){
            Intent intent= new Intent(BarraActivity.this,MiTerrenoActivity.class);
            startActivity(intent);
        }

        else if (id == R.id.compras) {
            Intent intent= new Intent(BarraActivity.this,MisComprasActivity.class);
            startActivity(intent);
        }

        else if (id == R.id.ventas) {
            Intent intent= new Intent(BarraActivity.this,MisVentasActivity.class);
            startActivity(intent);
        }

        else if (id == R.id.vender) {
            Intent intent= new Intent(BarraActivity.this,Vender1Activity.class);
            startActivity(intent);
        }

        else if (id == R.id.faq) {

        }

        else if (id == R.id.cerrarsesion){
            Intent intent= new Intent(BarraActivity.this,LoginActivity.class);
            startActivity(intent);

        } else if (id == R.id.ventana){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void recieveBundles(Context context) {
        usuario = getIntent().getParcelableExtra(usuario.getClassName());
        Toast.makeText(context, usuario.toString(), Toast.LENGTH_SHORT).show();
    }
}
