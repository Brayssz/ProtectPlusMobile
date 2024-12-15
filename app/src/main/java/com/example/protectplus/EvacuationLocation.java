package com.example.protectplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.protectplus.model.LocationModel;

import java.util.ArrayList;
import java.util.List;

public class EvacuationLocation extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<LocationModel> locationList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evacuation_location);

        recyclerView = findViewById(R.id.recyclerView);

        // Initialize data
        locationList = new ArrayList<>();
        locationList.add(new LocationModel("Barangay Poblacion", "PEOPLE’S PARK",
                "19 Lakandula St, Mariveles, 2106 Bataan", R.drawable.poblacion));
        locationList.add(new LocationModel("Barangay Poblacion", "PEOPLE’S PARK",
                "19 Lakandula St, Mariveles, 2106 Bataan", R.drawable.poblacion));
        locationList.add(new LocationModel("Barangay Poblacion", "PEOPLE’S PARK",
                "19 Lakandula St, Mariveles, 2106 Bataan", R.drawable.poblacion));
        locationList.add(new LocationModel("Barangay Poblacion", "PEOPLE’S PARK",
                "19 Lakandula St, Mariveles, 2106 Bataan", R.drawable.poblacion));
        locationList.add(new LocationModel("Barangay Poblacion", "PEOPLE’S PARK",
                "19 Lakandula St, Mariveles, 2106 Bataan", R.drawable.poblacion));

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LocationAdapter adapter = new LocationAdapter(this, locationList);
        recyclerView.setAdapter(adapter);
    }
}