package com.bhadresh.navigationappdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.nevView);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.nevToolbar);
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.Fram, new HomeFragment());


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_draw_open, R.string.navigation_draw_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Fram, new HomeFragment());

        }
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNev);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.Fram, new HomeFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fram, new HomeFragment()).commit();
                break;
            case R.id.camera:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fram, new CameraFragment()).commit();
                break;
            case R.id.user:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fram, new UserFragment()).commit();
                break;
            case R.id.move:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fram, new MoveFragment()).commit();
                break;
            case R.id.send:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fram, new SendFragment()).commit();
                Intent intent = new Intent(this, CameraActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.camera:
                    selectedFragment = new CameraFragment();
                    break;
                case R.id.user:
                    selectedFragment = new UserFragment();
                    break;
                case R.id.move:
                    selectedFragment = new MoveFragment();
                    break;
                case R.id.send:
                    selectedFragment = new SendFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.Fram, selectedFragment).commit();
            return true;
        }
    };
}