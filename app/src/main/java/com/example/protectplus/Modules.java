package com.example.protectplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.protectplus.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Modules extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ModulesMenuAdapter adapter;
    private List<MenuItem> menuItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);

        recyclerView = findViewById(R.id.recyclerView); // Your RecyclerView ID
        menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("Flood", R.drawable.flood_icon));
        menuItems.add(new MenuItem("Earthquake", R.drawable.earthquake_icon));
        menuItems.add(new MenuItem("Volcanic Eruption", R.drawable.volcanic_eruption_icon));
        menuItems.add(new MenuItem("Fire", R.drawable.fire_icon));
        menuItems.add(new MenuItem("Landslide", R.drawable.landslide_icon));
        menuItems.add(new MenuItem("Tsunami", R.drawable.tsunami_icon));
        menuItems.add(new MenuItem("Heat Wave", R.drawable.heatwave_icon));
        menuItems.add(new MenuItem("Virus", R.drawable.virus_icon));

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns
        adapter = new ModulesMenuAdapter(menuItems);
        recyclerView.setAdapter(adapter);
    }
}