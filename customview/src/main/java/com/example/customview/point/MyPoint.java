package com.example.customview.point;

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
 * @desc 点
 */
public class MyPoint extends View {
    private Paint paint;

    public MyPoint(Context context) {
        super(context);
    }

    public MyPoint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public MyPoint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(width(widthMeasureSpec), height(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        canvas.drawPoint(Integer.valueOf(getWidth() / 2).floatValue(), Integer.valueOf(getHeight() / 2).floatValue(), paint);
    }

    /**
     * 宽
     *
     * @param widthMeasureSpec widthMeasureSpec
     * @return 宽
     */
    private int width(int widthMeasureSpec) {
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        specSize += 600;
        if (specMode == MeasureSpec.AT_MOST) {
            specSize += 200;
        } else if (specMode == MeasureSpec.EXACTLY) {
            specSize += 20;
        }
        return specSize;
    }

    /**
     * 高
     *
     * @param heightMeasureSpec heightMeasureSpec
     * @return 高
     */
    private int height(int heightMeasureSpec) {
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        specSize += 600;
        if (specMode == MeasureSpec.AT_MOST) {
            specSize += 200;
        } else if (specMode == MeasureSpec.EXACTLY) {
            specSize += 20;
        }
        return specSize;
    }
}
