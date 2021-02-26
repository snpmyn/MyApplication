package com.example.fairy.app;

import android.app.Application;

/**
 * Created on 2021/1/12
 *
 * @author zsp
 * @desc 应用
 * 官方：
 * Base class for those who need to maintain global application state.
 * You can provide your own implementation by specifying its name in your AndroidManifest.xml's <application> tag,
 * which will cause that class to be instantiated for you when the process for your application/package is created.
 * Application 类（基础类）用于维护应用程序全局状态。
 * 你可提供自己的实现，在 AndroidManifest.xml 文件 <application> 标签指定它的名字，
 * 这将引起你的应用进程被创建时 Application 类为你被实例化。
 * <p>
 * Android 系统在每应用程序运行时创且仅创一 Application 实例，故 Application 可作单例（Singleton）模式一类；
 * 对象生命周期整应用程序最长，等同应用程序生命周期；
 * 全局唯一，不同 Activity、Service 中获实例相同；
 * 数据传递、数据共享、数据缓存等。
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
