package toast;

import android.view.View;
import android.widget.Button;

import com.example.fairy.utils.window.SystemAlertWindowUtils;
import com.example.fairy.widget.toast.ToastKit;
import com.example.fairy.widget.toast.WindowHeadToast;
import com.example.myapplication.R;

import base.BaseActivity;

/**
 * @desc: 吐司页
 * @author: zsp
 * @date: 2020-09-03 09:04
 */
public class ToastActivity extends BaseActivity implements View.OnClickListener {
    private Button toastActivityBtnPop;

    /**
     * 布局资源 ID
     *
     * @return 布局资源 ID
     */
    @Override
    protected int layoutResId() {
        return R.layout.activity_toast;
    }

    /**
     * 初始控件
     */
    @Override
    protected void stepUi() {
        toastActivityBtnPop = findViewById(R.id.toastActivityBtnPop);
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
        toastActivityBtnPop.setOnClickListener(this);
    }

    /**
     * 初始数据
     */
    @Override
    protected void initData() {

    }

    /**
     * 开始逻辑
     */
    @Override
    protected void startLogic() {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.toastActivityBtnPop) {
            pop();
        }
    }

    /**
     * 弹出
     */
    private void pop() {
        if (SystemAlertWindowUtils.getInstance().execute(this)) {
            final WindowHeadToast windowHeadToast = new WindowHeadToast(this, "我的客服", "您收到一条新消息", null);
            windowHeadToast.setOnViewClickListener(extraMap -> {
                ToastKit.showShort("点击");
                windowHeadToast.dismiss();
            });
            windowHeadToast.show();
        }
    }
}
