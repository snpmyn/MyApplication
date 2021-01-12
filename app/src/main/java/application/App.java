package application;

import com.example.fairy.utils.listener.AppListener;
import com.example.fairy.utils.log.LogUtils;

/**
 * Created on 2020-09-09
 *
 * @author zsp
 * @desc 应用
 */
public class App extends com.example.fairy.app.App {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化配置
        initConfiguration();
    }

    /**
     * 初始化配置
     */
    private void initConfiguration() {
        // 日志工具类初始配置
        LogUtils.Builder.initConfiguration(true, true, true, true);
        // 应用监听初始配置
        AppListener.getInstance().initConfiguration(this);
    }
}
