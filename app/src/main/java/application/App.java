package application;

import android.app.Application;

import utils.listener.AppListener;
import utils.log.LogUtils;

/**
 * Created on 2020-09-09
 *
 * @author zsp
 * @desc 应用
 */
public class App extends Application {
    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // 初始配置
        initConfiguration();
    }

    public static Application getInstance() {
        return instance;
    }

    /**
     * 初始配置
     */
    private void initConfiguration() {
        // 日志工具类初始配置
        LogUtils.Builder.initConfiguration(true, true, true, true);
        // 应用监听初始配置
        AppListener.getInstance().initConfiguration(this);
    }
}
