package com.example.protectplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.protectplus.model.Feedback;
import com.example.protectplus.model.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    private RecyclerView recyclerView;

    private RecyclerView feedbackRecyclerView;

    private HorizontalMenuAdapter adapter;
    private List<MenuItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.menuRecyclerView);
        feedbackRecyclerView = findViewById(R.id.feedbackRecyclerView);
        itemList = new ArrayList<>();

        // Add some sample items
        itemList.add(new MenuItem("Modules", R.drawable.modules_icon));
        itemList.add(new MenuItem("Directory", R.drawable.directory_icon));
        itemList.add(new MenuItem("Location", R.drawable.location_icon));
        itemList.add(new MenuItem("Certificates", R.drawable.certificates_icon));

        // Set the LayoutManager to horizontal
        LinearLayoutManager menuLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(menuLayoutManager);

        // Set the adapter
        adapter = new HorizontalMenuAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Create and populate the feedback list
        List<Feedback> feedbackList = new ArrayList<>();
        feedbackList.add(new Feedback(R.drawable.person_1, "Galing!!!", true));
        feedbackList.add(new Feedback(R.drawable.person_1, "Thanks for the knowledge", false));
        feedbackList.add(new Feedback(R.drawable.person_1, "Cool.", true));
        feedbackList.add(new Feedback(R.drawable.person_1, "Thanks for the knowledge", false));
        feedbackList.add(new Feedback(R.drawable.person_1, "Galing!!!", true));

        // Set LayoutManager for feedbackRecyclerView
        LinearLayoutManager feedbackLayoutManager = new LinearLayoutManager(this);
        feedbackRecyclerView.setLayoutManager(feedbackLayoutManager);

        // Set the adapter for feedbackRecyclerView
        FeedbackAdapter feedbackAdapter = new FeedbackAdapter(this, feedbackList);
        feedbackRecyclerView.setAdapter(feedbackAdapter);
    }

}