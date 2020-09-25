package utils.view;

import android.view.View;

/**
 * Created on 2020-09-15
 *
 * @author zsp
 * @desc 视图工具类
 */
public class ViewUtils {
    private boolean alreadyClick;
    private long clickTime;

    /**
     * 双重点击监听
     */
    public interface OnDoubleClickListener {
        /**
         * 双重点击
         */
        void onDoubleClick();
    }

    /**
     * 双重点击检测
     *
     * @param view                  视图
     * @param onDoubleClickListener 双重点击监听
     */
    public void doubleClickCheck(View view, final OnDoubleClickListener onDoubleClickListener) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alreadyClick) {
                    if (((System.currentTimeMillis() - clickTime) < 200) && null != onDoubleClickListener) {
                        onDoubleClickListener.onDoubleClick();
                    }
                    alreadyClick = false;
                } else {
                    clickTime = System.currentTimeMillis();
                    alreadyClick = true;
                }
            }
        });
    }
}