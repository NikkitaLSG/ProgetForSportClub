package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Инициализация View Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Настройка BottomNavigationView
        BottomNavigationView navView = binding.navView; // Используем View Binding для доступа к navView

        // Указываем все верхнеуровневые пункты меню для навигации
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.registerFragment) // Добавьте идентификатор фрагмента регистрации
                .build();

        // Получаем NavController и связываем его с ActionBar и BottomNavigationView
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController); // Используем navView из View Binding

        // Устанавливаем обработчик навигации для BottomNavigationView
        navView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                navController.navigate(R.id.navigation_home);
                return true;
            } else if (itemId == R.id.navigation_dashboard) {
                navController.navigate(R.id.navigation_dashboard);
                return true;
            } else if (itemId == R.id.navigation_notifications) {
                navController.navigate(R.id.navigation_notifications);
                return true;
            } else if (itemId == R.id.registerFragment) {
                navController.navigate(R.id.registerFragment);
                return true;
            }
            return false;
        });

    }
}
