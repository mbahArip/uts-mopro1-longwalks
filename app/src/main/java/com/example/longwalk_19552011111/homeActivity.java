package com.example.longwalk_19552011111;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity {
    String firstName, fullName;
    View toolbar;
    boolean doubleBackToExitPressedOnce  = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        toolbar = findViewById(R.id.toolbar__group);

//        Intent intent = getIntent();
//        fullName = intent.getExtras().getString("fullName");

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new fragment__daily()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch(menuItem.getItemId()){
                        case R.id.fragment__daily:
                            selectedFragment = new fragment__daily();
                            break;

                        case R.id.fragment__convo:
                            selectedFragment = new fragment__convo();
                            break;

                        case R.id.fragment__profile:
                            selectedFragment = new fragment__profile();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, selectedFragment).commit();

                    return true;
                }
            };

    public void hideToolbar(){
        System.out.println("Hide");
        toolbar.setVisibility(View.GONE);
    }
    public void showToolbar(){
        System.out.println("Show");
        toolbar.setVisibility(View.VISIBLE);
    }
}