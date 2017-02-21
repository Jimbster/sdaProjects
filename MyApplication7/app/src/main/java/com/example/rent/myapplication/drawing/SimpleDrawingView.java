package com.example.rent.myapplication.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by RENT on 2017-02-15.
 */

public class SimpleDrawingView extends View {
    private Paint paint;
    private Path path = new Path();
    public SimpleDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                path.moveTo(x,y);
                    break;
            }
            case MotionEvent.ACTION_MOVE: {
                path.lineTo(x,y);
                    break;
            }
        }
        postInvalidate();
        return true;
    }

    void clear(){
        path=new Path();
        postInvalidate();
    }
}
