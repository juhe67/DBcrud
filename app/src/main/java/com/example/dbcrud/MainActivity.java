package com.example.dbcrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private FrameLayout container;
    private NavigationBarView navigationBarView;
    private final DashboardFragment dashboardFragment = new DashboardFragment();
    private final ShopFragment shopFragment = new ShopFragment();
    private final SettingFragment settingFragment = new SettingFragment();

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadFragment(dashboardFragment);
        navigationBarView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_dashboard:
                    loadFragment(dashboardFragment);
                    return true;
                case R.id.action_shop:
                    loadFragment(shopFragment);
                    return true;
                case R.id.action_setting:
                    loadFragment(settingFragment);
                    return true;
            }
            return false;
        });
    }

    private void initView() {
        container = findViewById(R.id.container);
        navigationBarView = findViewById(R.id.bottom_navigation);
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}
