package com.example.customview.rect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created on 2020/7/3.
 *
 * @author zsp
 * @desc 圆角矩形
 */
public class MyRoundRect extends View {
    private Paint paint;

    public MyRoundRect(Context context) {
        super(context);
    }

    public MyRoundRect(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public MyRoundRect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        paint.setColor(Color.GREEN);
        paint.setAlpha(66);
        canvas.drawRoundRect(Integer.valueOf(getWidth() / 2 - 240).floatValue(), Integer.valueOf(getHeight() / 2 - 120).floatValue(),
                Integer.valueOf(getWidth() / 2 + 240).floatValue(), Integer.valueOf(getHeight() / 2 + 120).floatValue(),
                24.0f, 24.0f, paint);
    }
}
