package com.example.continents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.continents.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().add(R.id.Container,new ContinentFragment()).
                addToBackStack(null).commit();


    }
}