package utils.intent;

import android.content.Context;
import android.content.Intent;

/**
 * Created on 2020-08-19
 *
 * @author zsp
 * @desc 意图工具类
 */
public class IntentUtils {
    private static IntentUtils instance;

    public static IntentUtils getInstance() {
        if (null == instance) {
            synchronized (IntentUtils.class) {
                if (null == instance) {
                    instance = new IntentUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 跳转
     *
     * @param context 上下文
     * @param c       类
     */
    public void jump(Context context, Class<?> c) {
        Intent intent = new Intent();
        intent.setClass(context, c);
        context.startActivity(intent);
    }
}
