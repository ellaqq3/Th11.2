package com.example.th112;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    TextView textView;
    ArrayList<String> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_draw_open, R.string.navigation_draw_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, new SettingsFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void editTextView() {
        System.out.println("Lähettäminen onnistui Mainista");
        FragmentManager manager = getSupportFragmentManager();
        SettingsFragment fragment = (SettingsFragment) manager.findFragmentById(R.id.fragment_container);
        lista = fragment.sendInfo();

        System.out.println(lista.size());

        int korkeus = Integer.parseInt(lista.get(3));
        int fontti = Integer.parseInt(lista.get(0));
        int leveys = Integer.parseInt(lista.get(1));
        int rivit = Integer.parseInt(lista.get(2));

        textView = findViewById(R.id.textView2);
        final FrameLayout.LayoutParams layoutparams = (FrameLayout.LayoutParams) textView.getLayoutParams();

        textView.setTextSize(fontti);
        textView.setLines(rivit);
        layoutparams.width = leveys;
        layoutparams.height = korkeus;
    }
}