package widget.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created on 2020-09-23
 *
 * @author zsp
 * @desc 测量版 GridView
 * 解决{@link GridView}与{@link android.widget.ScrollView}冲突。
 */
public class MeasuredGridView extends GridView {
    public MeasuredGridView(Context context) {
        super(context);
    }

    public MeasuredGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasuredGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // MeasureSpec.makeMeasureSpec(int size，int mode)
        // size: 父布局提供的大小参考
        // mode: 规格（EXACTLY、AT_MOST、UNSPECIFIED）
        // Integer.MAX_VALUE >> 2 表示父布局提供无限大参考大小，即 ListView 无边界。
        // MeasureSpec.AT_MOST 表示根据布局大小确定 ListView 最终高，有多少内容就显示多高。
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

