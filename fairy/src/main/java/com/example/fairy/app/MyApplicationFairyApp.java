package com.example.fairy.app;

import android.app.Application;

/**
 * Created on 2021/1/12
 *
 * @author zsp
 * @desc 应用
 */
public class MyApplicationFairyApp extends Application {
    private static Application instance;

    /**
     * 应用程序创调
     * <p>
     * 创和实例化任何应用程序状态变量或共享资源变量，方法内获 Application 单例。
     */
    @Override
    public void onCreate() {
        super.onCreate();
        // Application 本已单例
        instance = this;
    }

    public static Application getInstance() {
        return instance;
    }
}
