package base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * @desc: 基类
 * @author: zsp
 * @date: 2020-08-18 14:44
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResId());
        stepUi();
        initConfiguration();
        setListener();
        initData();
        startLogic();
    }

    /**
     * 布局资源 ID
     *
     * @return 布局资源 ID
     */
    protected abstract int layoutResId();

    /**
     * 初始控件
     */
    protected abstract void stepUi();

    /**
     * 初始配置
     */
    protected abstract void initConfiguration();

    /**
     * 设置监听
     */
    protected abstract void setListener();

    /**
     * 初始数据
     */
    protected abstract void initData();

    /**
     * 开始逻辑
     */
    protected abstract void startLogic();
}
