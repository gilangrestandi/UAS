package com.example.uasmobiles4gilangrestandi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private FrameLayout container;
    private NavigationBarView navigationBarView;
    private final DashboardFragment dashboardFragment = new DashboardFragment();
    private final StoreFragment storeFragment = new StoreFragment();
    private final SettingFragment settingFragment = new SettingFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        loadFragment(dashboardFragment);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_dashboard:
                        loadFragment(dashboardFragment);
                        return true;
                    case R.id.action_shop:
                        loadFragment(storeFragment);
                        return true;
                    case R.id.action_setting:
                        loadFragment(settingFragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void initView(){
        container = findViewById(R.id.container);
        navigationBarView = findViewById(R.id.bottom_navigation);
    }

    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }
}