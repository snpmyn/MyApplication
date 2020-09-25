package utils.dimension;

import android.content.Context;

/**
 * Created on 2020-08-31
 *
 * @author zsp
 * @desc 尺寸工具类
 */
public class DimensionUtils {
    public static int dipToPx(Context context, float dipValue) {
        return (int) (dipValue * context.getResources().getDisplayMetrics().density + 0.5f);
    }
}
