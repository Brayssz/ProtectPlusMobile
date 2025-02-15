package com.example.protectplus.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.protectplus.R;

public class ColoringView extends View {
    private Bitmap baseImage, coloringBitmap;
    private Canvas coloringCanvas;
    private Paint paint;
    private int selectedColor = Color.RED;

    public ColoringView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ColoringView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        setBackgroundColor(Color.WHITE); // Debugging background

        // Load the base image (ensure it's in res/drawable)
        baseImage = BitmapFactory.decodeResource(getResources(), R.drawable.coloring_game);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (baseImage != null) {
            baseImage = Bitmap.createScaledBitmap(baseImage, w, h, true);
            coloringBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            coloringCanvas = new Canvas(coloringBitmap);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (baseImage != null) {
            canvas.drawBitmap(baseImage, 0, 0, null);
            canvas.drawBitmap(coloringBitmap, 0, 0, null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE: // Supports dragging
                applyColor((int) x, (int) y);
                invalidate(); // Redraw the view
                return true;
        }
        return super.onTouchEvent(event);
    }

    private void applyColor(int x, int y) {
        if (coloringCanvas != null) {
            paint.setColor(selectedColor);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            coloringCanvas.drawCircle(x, y, 40, paint);
        }
    }

    public void setSelectedColor(int color) {
        this.selectedColor = color;
    }
}
