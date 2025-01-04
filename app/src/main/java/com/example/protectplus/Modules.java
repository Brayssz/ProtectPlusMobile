package com.example.protectplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.protectplus.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Modules extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ModulesMenuAdapter adapter;
    private List<MenuItem> menuItems;
    private TextView BackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);

        BackBtn = findViewById(R.id.back_btn);

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

        adapter.setOnMenuItemClickListener(menuItem -> {
            Intent intent = null;

            //get Module name
            String ItemName = menuItem.getTitle();

            intent = new Intent(Modules.this, Lecture.class);


            if (intent != null) {
                startActivity(intent);
            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}