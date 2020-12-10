package mvp;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

import base.BaseActivity;
import mvp.contract.MvpActivityContract;

/**
 * @desc: MVP 页
 * @author: zsp
 * @date: 2020-09-07 15:43
 */
public class MvpActivity extends BaseActivity implements View.OnClickListener, MvpActivityContract.MvpActivityView {
    private TextView mvpActivityTvText;
    private Button mvpActivityBtnUpdate;
    private MvpActivityContract.MvpActivityPresenter mvpActivityPresenter;

    /**
     * 布局资源 ID
     *
     * @return 布局资源 ID
     */
    @Override
    protected int layoutResId() {
        return R.layout.activity_mvp;
    }

    /**
     * 初始控件
     */
    @Override
    protected void stepUi() {
        mvpActivityTvText = findViewById(R.id.mvpActivityTvText);
        mvpActivityBtnUpdate = findViewById(R.id.mvpActivityBtnUpdate);
    }

    /**
     * 初始配置
     */
    @Override
    protected void initConfiguration() {

    }

    /**
     * 设置监听
     */
    @Override
    protected void setListener() {
        mvpActivityBtnUpdate.setOnClickListener(this);
    }

    /**
     * 初始数据
     */
    @Override
    protected void initData() {
        mvpActivityPresenter = new MvpActivityContract.MvpActivityPresenter(this);
    }

    /**
     * 开始逻辑
     */
    @Override
    protected void startLogic() {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.mvpActivityBtnUpdate) {
            mvpActivityPresenter.request();
        }
    }

    /**
     * 更新文本
     *
     * @param text 文本
     */
    @Override
    public void updateText(String text) {
        mvpActivityTvText.setText(text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mvpActivityPresenter.detachView();
    }
}
