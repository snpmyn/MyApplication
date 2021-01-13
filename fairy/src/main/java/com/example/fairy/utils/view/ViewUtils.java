package com.example.fairy.utils.view;

import android.view.View;

import com.example.fairy.value.MyApplicationFairyMagic;

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
        view.setOnClickListener(view1 -> {
            if (alreadyClick) {
                if (((System.currentTimeMillis() - clickTime) < MyApplicationFairyMagic.INT_TWO_HUNDRED) && null != onDoubleClickListener) {
                    onDoubleClickListener.onDoubleClick();
                }
                alreadyClick = false;
            } else {
                clickTime = System.currentTimeMillis();
                alreadyClick = true;
            }
        });
    }
}
