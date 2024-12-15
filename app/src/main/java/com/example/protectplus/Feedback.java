package com.example.protectplus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Feedback extends AppCompatActivity {

    private RecyclerView feedbackRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        feedbackRecyclerView = findViewById(R.id.feedbackRecyclerView);

        // Create and populate the feedback list
        List<com.example.protectplus.model.Feedback> feedbackList = new ArrayList<>();
        feedbackList.add(new com.example.protectplus.model.Feedback(R.drawable.person_1, "Galing!!!", true));
        feedbackList.add(new com.example.protectplus.model.Feedback(R.drawable.person_1, "Thanks for the knowledge", false));
        feedbackList.add(new com.example.protectplus.model.Feedback(R.drawable.person_1, "Cool.", true));
        feedbackList.add(new com.example.protectplus.model.Feedback(R.drawable.person_1, "Thanks for the knowledge", false));
        feedbackList.add(new com.example.protectplus.model.Feedback(R.drawable.person_1, "Galing!!!", true));
        feedbackList.add(new com.example.protectplus.model.Feedback(R.drawable.person_1, "Thanks for the knowledge", false));

        // Set LayoutManager for feedbackRecyclerView
        LinearLayoutManager feedbackLayoutManager = new LinearLayoutManager(this);
        feedbackRecyclerView.setLayoutManager(feedbackLayoutManager);

        // Set the adapter for feedbackRecyclerView
        FeedbackAdapter feedbackAdapter = new FeedbackAdapter(this, feedbackList);
        feedbackRecyclerView.setAdapter(feedbackAdapter);
    }
}