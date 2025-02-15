package com.example.protectplus.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PuzzleView extends View {
    private Bitmap puzzleImage;
    private List<Bitmap> pieces = new ArrayList<>();
    private Paint paint = new Paint();
    private Paint borderPaint = new Paint(); // For tile borders

    private int gridSize = 3; // 3x3 puzzle
    private int emptyRow, emptyCol;
    private int tileWidth, tileHeight;

    private int refImagePadding = 50; // Space between reference image and puzzle
    private int refImageHeight = 200; // Height of the reference image

    public PuzzleView(Context context) {
        super(context);
        init();
    }

    public PuzzleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PuzzleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        borderPaint.setColor(Color.BLACK);
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(4); // Border thickness
    }

    public void setPuzzleImage(Bitmap bitmap) {
        this.puzzleImage = bitmap;
        splitImage();
        invalidate(); // Redraw view
    }

    private void splitImage() {
        if (puzzleImage == null) return;

        pieces.clear();
        int rows = gridSize, cols = gridSize;
        tileWidth = puzzleImage.getWidth() / cols;
        tileHeight = puzzleImage.getHeight() / rows;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Bitmap piece = Bitmap.createBitmap(puzzleImage, col * tileWidth, row * tileHeight, tileWidth, tileHeight);
                pieces.add(piece);
            }
        }

        emptyRow = gridSize - 1;
        emptyCol = gridSize - 1;
    }

    public void shuffleTiles() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) { // Perform 100 valid random swaps
            int direction = random.nextInt(4); // 0 = up, 1 = down, 2 = left, 3 = right
            int newRow = emptyRow, newCol = emptyCol;

            switch (direction) {
                case 0: newRow--; break; // Move up
                case 1: newRow++; break; // Move down
                case 2: newCol--; break; // Move left
                case 3: newCol++; break; // Move right
            }

            if (newRow >= 0 && newRow < gridSize && newCol >= 0 && newCol < gridSize) {
                swapTiles(newRow, newCol);
            }
        }
        invalidate();  // Refresh the puzzle view
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            float x = event.getX();
            float y = event.getY();
            handleTileClick(x, y);
            return true;
        }
        return super.onTouchEvent(event);
    }

    private void handleTileClick(float x, float y) {
        int clickedRow = (int) ((y - (refImageHeight + refImagePadding)) / tileHeight);
        int clickedCol = (int) (x / tileWidth);

        if (isValidMove(clickedRow, clickedCol)) {
            swapTiles(clickedRow, clickedCol);
            invalidate();  // Redraw the puzzle
        }
    }

    private boolean isValidMove(int row, int col) {
        return (Math.abs(emptyRow - row) == 1 && emptyCol == col) ||
                (Math.abs(emptyCol - col) == 1 && emptyRow == row);
    }

    private void swapTiles(int row, int col) {
        int index1 = row * gridSize + col;
        int index2 = emptyRow * gridSize + emptyCol;

        Collections.swap(pieces, index1, index2);

        emptyRow = row;
        emptyCol = col;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (pieces.isEmpty() || puzzleImage == null) return;

        int viewWidth = getWidth();
        int viewHeight = getHeight();

        // Scale and position the reference image
        int refWidth = viewWidth / 2;
        Bitmap refImage = Bitmap.createScaledBitmap(puzzleImage, refWidth, refImageHeight, false);
        canvas.drawBitmap(refImage, (viewWidth - refWidth) / 2, 0, paint);

        // Center the puzzle grid
        int gridWidth = viewWidth * 3 / 4;
        int gridHeight = gridWidth;
        int startX = (viewWidth - gridWidth) / 2;
        int startY = refImageHeight + refImagePadding; // Adjusted padding

        tileWidth = gridWidth / gridSize;
        tileHeight = gridHeight / gridSize;

        int index = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (index < pieces.size()) {
                    int x = startX + col * tileWidth;
                    int y = startY + row * tileHeight;
                    canvas.drawBitmap(Bitmap.createScaledBitmap(pieces.get(index), tileWidth, tileHeight, false), x, y, paint);

                    // Draw border around tiles
                    canvas.drawRect(x, y, x + tileWidth, y + tileHeight, borderPaint);

                    index++;
                }
            }
        }
    }
}
