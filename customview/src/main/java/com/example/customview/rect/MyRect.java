package com.example.customview.rect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created on 2020/7/2.
 *
 * @author zsp
 * @desc 矩形
 */
public class MyRect extends View {
    private Paint paint;

    public MyRect(Context context) {
        super(context);
    }

    public MyRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public MyRect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        paint.setColor(Color.CYAN);
        canvas.drawRect(Integer.valueOf(getWidth() / 2 - 240).floatValue(), Integer.valueOf(getHeight() / 2 - 120).floatValue(),
                Integer.valueOf(getWidth() / 2 + 240).floatValue(), Integer.valueOf(getHeight() / 2 + 120).floatValue(), paint);
    }
}
