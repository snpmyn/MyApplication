package com.example.fairy.utils.intent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created on 2020-08-19
 *
 * @author zsp
 * @desc 意图跳转
 */
public class IntentJump {
    private static IntentJump instance;

    public static IntentJump getInstance() {
        if (null == instance) {
            synchronized (IntentJump.class) {
                if (null == instance) {
                    instance = new IntentJump();
                }
            }
        }
        return instance;
    }

    /**
     * 跳转
     *
     * @param withValueIntent     携值意图
     * @param context             上下文
     * @param targetActivityClass 目标活动
     */
    public void jump(Intent withValueIntent, Context context, Class<?> targetActivityClass) {
        Intent intent;
        if (null == withValueIntent) {
            intent = new Intent(context, targetActivityClass);
        } else {
            intent = withValueIntent;
            intent.setClass(context, targetActivityClass);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    /**
     * 携动画跳转
     *
     * @param withValueIntent     携值意图
     * @param activity            活动
     * @param targetActivityClass 目标活动
     */
    public void jumpWithAnimation(Intent withValueIntent, Activity activity, Class<?> targetActivityClass) {
        jump(withValueIntent, activity, targetActivityClass);
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
