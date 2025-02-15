package com.example.protectplus.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.protectplus.R;
import com.example.protectplus.game.PuzzleView;
import java.util.Collections;
import java.util.List;

public class PuzzleGameActivity extends AppCompatActivity {
    private PuzzleView puzzleView;
    private Button shuffleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_game);

        puzzleView = findViewById(R.id.puzzleView);
        shuffleButton = findViewById(R.id.shuffleButton);


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.images);
        puzzleView.setPuzzleImage(bitmap);

        shuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puzzleView.shuffleTiles();
            }
        });
    }
}
