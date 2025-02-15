package com.example.protectplus.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.protectplus.adapter.FeedbackAdapter;
import com.example.protectplus.adapter.HorizontalMenuAdapter;
import com.example.protectplus.R;
import com.example.protectplus.model.Feedback;
import com.example.protectplus.model.MenuItem;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    private RecyclerView recyclerView;

    private RecyclerView feedbackRecyclerView;

    private HorizontalMenuAdapter adapter;
    private List<MenuItem> itemList;

    private MaterialButton SeeMoreBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        SeeMoreBtn = findViewById(R.id.see_more);

        recyclerView = findViewById(R.id.menuRecyclerView);
        feedbackRecyclerView = findViewById(R.id.feedbackRecyclerView);
        itemList = new ArrayList<>();

        itemList.add(new MenuItem("Modules", R.drawable.modules_icon));
        itemList.add(new MenuItem("Directory", R.drawable.directory_icon));
        itemList.add(new MenuItem("Location", R.drawable.location_icon));
        itemList.add(new MenuItem("Certificates", R.drawable.certificates_icon));
        itemList.add(new MenuItem("Feedback", R.drawable.about_icon));

        LinearLayoutManager menuLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(menuLayoutManager);

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

        adapter.setOnMenuItemClickListener(menuItem -> {
            Intent intent = null;

            switch (menuItem.getTitle()) {
                case "Modules":
                    intent = new Intent(Dashboard.this, Modules.class);
                    break;
                case "Directory":
                    intent = new Intent(Dashboard.this, Hotlines.class);
                    break;
                case "Location":
                    intent = new Intent(Dashboard.this, EvacuationLocation.class);
                    break;
                case "Feedback":
                    intent = new Intent(Dashboard.this, HelpDesk.class);
                    break;
                case "Certificates":
                    intent = new Intent(Dashboard.this, EvacuationLocation.class);
                    break;
            }

            if (intent != null) {
                startActivity(intent);
            }
        });

        SeeMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, com.example.protectplus.view.Feedback.class);
                startActivity(intent);
            }
        });

    }

}