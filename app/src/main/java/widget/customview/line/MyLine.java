package widget.customview.line;

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
 * @desc 线
 */
public class MyLine extends View {
    private Paint paint;

    public MyLine(Context context) {
        super(context);
    }

    public MyLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public MyLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(24.0f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(Integer.valueOf(getWidth() / 2 - 200).floatValue(), Integer.valueOf(getHeight() / 2).floatValue(),
                Integer.valueOf(getWidth() / 2 + 200).floatValue(), Integer.valueOf(getHeight() / 2).floatValue(), paint);
    }
}
