package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize View Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Setting up BottomNavigationView
        BottomNavigationView navView = binding.navView;

        // Specify top-level destinations for navigation
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications,
                R.id.registerFragment) // Make sure this ID is correct
                .build();

        // Obtain NavController and set up ActionBar and BottomNavigationView
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        // Initialize UI components
        initializeUI();
    }

    private void initializeUI() {
        ImageView profileImage = findViewById(R.id.profile_image);
        TextView fullName = findViewById(R.id.full_name);
        RatingBar ratingBar = findViewById(R.id.rating_bar);

        // Set data
        profileImage.setImageResource(R.drawable.ic_dashboard_black_24dp); // Замените на ваше изображение без расширения
        fullName.setText("Иван Иванов");
        ratingBar.setRating(4); // Задайте рейтинг
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}
