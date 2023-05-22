package com.example.lastn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()) {
                    case R.id.favorite:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(MainActivity.this, "Избранное", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.volume:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(MainActivity.this, "Громкость", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.settings:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Toast.makeText(MainActivity.this, "Настройки", Toast.LENGTH_SHORT).show();
                        break;
                }


                return true;
            }
        });

    }
}