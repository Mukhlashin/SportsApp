package com.example.sportsapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sportsapp.fragment.BundesFragment;
import com.example.sportsapp.fragment.LaligaFragment;
import com.example.sportsapp.fragment.PremierFragment;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            fm = getSupportFragmentManager();
            switch (menuItem.getItemId()) {
                case R.id.rvPremier:
                    fm.beginTransaction().replace(R.id.main_container, new PremierFragment()).commit();
                    return true;
                case R.id.rvLaliga:
                    fm.beginTransaction().replace(R.id.main_container, new LaligaFragment()).commit();
                    return true;
                case R.id.rvBundes:
                    fm.beginTransaction().replace(R.id.main_container, new BundesFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.main_container, new PremierFragment()).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
