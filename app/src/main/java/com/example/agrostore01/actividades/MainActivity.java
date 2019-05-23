package com.example.agrostore01.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.agrostore01.R;
import com.example.agrostore01.adaptadores.ImagenAdapter;
import com.example.agrostore01.fragmentos.BuscarFragment;
import com.example.agrostore01.fragmentos.CarritoFragment;
import com.example.agrostore01.fragmentos.DashboardFragment;
import com.example.agrostore01.fragmentos.NotificacionesFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navegador;

    private DashboardFragment dashboardFragment = new DashboardFragment();
    private BuscarFragment buscarFragment = new BuscarFragment();
    private CarritoFragment carritoFragment = new CarritoFragment();
    private NotificacionesFragment notificacionesFragment = new NotificacionesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ViewPager viewPager = findViewById(R.id.ViewPagerOfertas);
        //ImagenAdapter adapter = new ImagenAdapter(this);
        //viewPager.setAdapter(adapter);

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

                case R.id.navigation_faq:
                    //Intent intent = new Intent(MainActivity.this, MisComprasActivity.class);
                    Intent intent = new Intent(MainActivity.this, Vender1Activity.class);
                    startActivity(intent);
                    break;
            }

            if (fragmento == null)
                return false;

            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragmento).commit();

            return true;
        }
    };

}
