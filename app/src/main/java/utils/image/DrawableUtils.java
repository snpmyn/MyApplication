package utils.image;

import application.App;
import utils.log.LogUtils;

/**
 * Created on 2020-09-14
 *
 * @author zsp
 * @desc 位图工具类
 */
public class DrawableUtils {
    /**
     * 获取位图资源 ID
     *
     * @param name         名称
     * @param defaultResId 默认资源 ID
     * @return 位图资源 ID
     */
    public static int getDrawableResIdByName(String name, int defaultResId) {
        try {
            int drawableResId = App.getInstance().getResources().getIdentifier(name, "drawable", App.getInstance().getPackageName());
            return drawableResId > 0 ? drawableResId : defaultResId;
        } catch (Exception e) {
            LogUtils.exception(e);
            return defaultResId;
        }
    }
}
